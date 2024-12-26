package com.jalian.organization_service.controller;

import com.jalian.organization_service.dto.OrganizationDto;
import com.jalian.organization_service.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PatchMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationService.saveOrganization(organizationDto));
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }
    
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationService.getOrganizationByCode(code));
    }
}
