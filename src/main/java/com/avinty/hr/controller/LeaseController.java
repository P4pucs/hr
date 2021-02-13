package com.avinty.hr.controller;

import com.avinty.hr.model.Lease;
import com.avinty.hr.service.LeaseService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "leases")
public class LeaseController {

    private final LeaseService leaseService;

    @GetMapping()
    public ResponseEntity<Object> getLeasesSum() {
        JSONObject response = new JSONObject();

        response.appendField("SUM", leaseService.getLeasesSum().toString());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "current/{id}")
    public ResponseEntity<Lease> getCurrentLeaseOfId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(leaseService.getCurrentLeaseOfId(id));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<List<Lease>> getAllLeasesOfId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(leaseService.getAllLeasesOfId(id));
    }

    @PostMapping()
    public ResponseEntity<Lease> createLease(@RequestBody Lease lease) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leaseService.createLease(lease));
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<Lease> closeLeaseById(@PathVariable Long id, @RequestBody Lease request) {
        return ResponseEntity.status(HttpStatus.OK).body(leaseService.closeLeaseById(id, request));
    }
}
