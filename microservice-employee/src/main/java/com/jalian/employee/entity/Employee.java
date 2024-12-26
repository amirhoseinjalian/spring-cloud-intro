package com.jalian.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
