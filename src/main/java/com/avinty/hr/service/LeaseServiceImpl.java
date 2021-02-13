package com.avinty.hr.service;

import com.avinty.hr.repository.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;
}
