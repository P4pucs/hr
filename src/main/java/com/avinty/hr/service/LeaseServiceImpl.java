package com.avinty.hr.service;

import com.avinty.hr.exception.CarActiveException;
import com.avinty.hr.exception.LeaseClosedException;
import com.avinty.hr.model.Lease;
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
    public Long getLeasesSum() {
        return leaseRepository.count();
    }

    @Override
    public Lease getCurrentLeaseOfId(Long id) {
        return leaseRepository.getActiveLeaseOfId(id);
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
    public Lease createLease(Lease lease) {
        int size = leaseRepository.getActiveCarIdById(lease.getCar().getId()).size();

        if (size != 0) {
            throw new CarActiveException("car " + lease.getCar().getId().toString() + " is active");
        }

        return leaseRepository.save(lease);
    }

    @Override
    @Transactional
    public Lease closeLeaseById(Long id, Lease request) {
        boolean exists = leaseRepository.findById(id).isPresent();

        if (!exists) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        Lease lease = leaseRepository.findById(id).get();

        if (!lease.isActive()) {
            throw new LeaseClosedException("lease " + lease.getId() + " already closed");
        }

        lease.setActive(request.isActive());
        lease.setEndDate(LocalDateTime.now());

        return leaseRepository.save(lease);
    }
}
