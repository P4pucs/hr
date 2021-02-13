package com.avinty.hr.service;

import com.avinty.hr.model.Lease;

import java.util.List;

public interface LeaseService {
    Long getLeasesSum();

    Lease getCurrentLeaseOfId(Long id);

    List<Lease> getAllLeasesOfId(Long id);

    Lease createLease(Lease lease);

    Lease closeLeaseById(Long id, Lease request);
}
