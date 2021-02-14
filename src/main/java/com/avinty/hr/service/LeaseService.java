package com.avinty.hr.service;

import com.avinty.hr.model.Lease;
import com.avinty.hr.payload.ActiveRequest;
import com.avinty.hr.payload.LeaseRequest;
import com.avinty.hr.payload.SumResponse;

import java.util.List;

public interface LeaseService {
    SumResponse getLeasesSum();

    List<Lease> getCurrentLeaseOfId(Long id);

    List<Lease> getAllLeasesOfId(Long id);

    Lease createLease(LeaseRequest request);

    Lease closeLeaseById(Long id, ActiveRequest request);
}
