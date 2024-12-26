package com.jalian.organization_service.mapper;

import com.jalian.organization_service.dto.OrganizationDto;
import com.jalian.organization_service.entity.Organization;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class OrganizationMapper {

    public static Organization getOrganization(OrganizationDto dto) {
        return new Organization(dto.getId(), dto.getName(), dto.getDescription(), dto.getCode(), dto.getCreateDate());
    }

    public static OrganizationDto getOrganizationDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getName(),
                organization.getDescription(),
                organization.getCode(),
                organization.getCreateDate()
        );
    }
}
