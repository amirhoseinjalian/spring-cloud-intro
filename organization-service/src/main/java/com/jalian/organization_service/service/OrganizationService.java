package com.jalian.organization_service.service;

import com.jalian.organization_service.dto.OrganizationDto;
import com.jalian.organization_service.mapper.OrganizationMapper;
import com.jalian.organization_service.repository.HardCodeOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private HardCodeOrganizationRepository repository;

    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        return OrganizationMapper.getOrganizationDto(
                repository.saveOrganization(
                        OrganizationMapper.getOrganization(organizationDto)
                )
        );
    }

    public List<OrganizationDto> getAllOrganizations() {
        List<OrganizationDto> dtos = new ArrayList<>();
        repository.getAllOrganizations().forEach(
                organization -> dtos.add(OrganizationMapper.getOrganizationDto(organization))
        );
        return dtos;
    }

    public OrganizationDto getOrganizationById(Long id) {
        return OrganizationMapper.getOrganizationDto(repository.getOrganizationById(id));
    }

    public OrganizationDto getOrganizationByCode(String code) {
        return OrganizationMapper.getOrganizationDto(
                repository.getAllOrganizations().stream().filter(org -> code.equals(org.getCode())).findFirst().get()
        );
    }
}
