package com.jalian.employee.dto;

public record EmployeeDto(
        String username, String password, String firstName,
        String lastName, String email, Long departmentId
        ) {
}
