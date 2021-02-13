package com.avinty.hr.controller;

import com.avinty.hr.service.LeaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "leases")
public class LeaseController {

    private final LeaseService leaseService;
}
