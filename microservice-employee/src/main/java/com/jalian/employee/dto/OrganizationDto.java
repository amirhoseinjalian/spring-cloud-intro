package com.jalian.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private Long id;
    private String name;
    private String description;
    private String code;
    private LocalDate createDate;
}
