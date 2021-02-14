package com.avinty.hr.service;

import com.avinty.hr.exception.BadValueException;
import com.avinty.hr.exception.CarActiveException;
import com.avinty.hr.exception.LeaseClosedException;
import com.avinty.hr.model.Lease;
import com.avinty.hr.payload.ActiveRequest;
import com.avinty.hr.payload.LeaseRequest;
import com.avinty.hr.payload.SumResponse;
import com.avinty.hr.repository.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;

    @Override
    public SumResponse getLeasesSum() {
        return new SumResponse(leaseRepository.count());
    }

    @Override
    public List<Lease> getCurrentLeaseOfId(Long id) {
        return leaseRepository.getActiveLeasesOfId(id);
    }

    @Override
    public List<Lease> getAllLeasesOfId(Long id) {
        List<Lease> leases = leaseRepository.getLeasesOfUserId(id);

        if (leases.isEmpty()) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        return leaseRepository.getLeasesOfUserId(id);
    }

    @Override
    @Transactional
    public Lease createLease(LeaseRequest request) {
        int size = leaseRepository.getActiveCarIdById(request.getCar().getId()).size();

        if (size != 0) {
            throw new CarActiveException("car " + request.getCar().getId().toString() + " is active");
        }

        Lease lease = new Lease(request.getUser(), request.getCar(), request.getStartCity(), request.getEndCity());

        return leaseRepository.save(lease);
    }

    @Override
    @Transactional
    public Lease closeLeaseById(Long id, ActiveRequest request) {
        if (request.isActive()) {
            throw new BadValueException("Cannot send true");
        }

        Lease lease = leaseRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

        if (!lease.isActive()) {
            throw new LeaseClosedException("lease " + lease.getId() + " already closed");
        }

        lease.setActive(request.isActive());
        lease.setEndDate(LocalDateTime.now());

        return leaseRepository.save(lease);
    }
}
