package com.jalian.organization_service.repository;

import com.jalian.organization_service.database.OrganizationDatabase;
import com.jalian.organization_service.entity.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardCodeOrganizationRepository {

    private final List<Organization> organizations = OrganizationDatabase.getORGANIZATIONS();

    public Organization getOrganizationById(Long organizationId) {
        return organizations.stream().filter(organization -> organization.getId().equals(organizationId)).findFirst().orElse(null);
    }

    public List<Organization> getAllOrganizations() {
        return organizations;
    }

    public Organization saveOrganization(Organization organization) {
        organization.setId((long) (organizations.size() + 1));
        organizations.add(organization);
        return organization;
    }

    public void deleteOrganization(Organization organization) {
        organizations.remove(organization);
    }
}
