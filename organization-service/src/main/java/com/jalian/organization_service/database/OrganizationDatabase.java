package com.jalian.organization_service.database;

import com.jalian.organization_service.entity.Organization;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public final class OrganizationDatabase {

    @Getter
    private static final List<Organization> ORGANIZATIONS = List.of(
            new Organization(1L, "1 org", "1 description", "1 code", LocalDate.now()),
            new Organization(2L, "2 org", "2 description", "2 code", LocalDate.now()),
            new Organization(3L, "1 org", "3 description", "3 code", LocalDate.now()),
            new Organization(4L, "4 org", "4 description", "4 code", LocalDate.now()),
            new Organization(5L, "5 org", "5 description", "5 code", LocalDate.now()),
            new Organization(6L, "6 org", "6 description", "6 code", LocalDate.now()),
            new Organization(7L, "7 org", "7 description", "7 code", LocalDate.now()),
            new Organization(8L, "8 org", "8 description", "8 code", LocalDate.now()),
            new Organization(9L, "9 org", "9 description", "9 code", LocalDate.now()),
            new Organization(10L, "10 org", "10 description", "10 code", LocalDate.now()),
            new Organization(11L, "11 org", "11 description", "11 code", LocalDate.now()),
            new Organization(12L, "12 org", "12 description", "12 code", LocalDate.now())
    );
}
