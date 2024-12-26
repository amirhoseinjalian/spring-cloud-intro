package com.jalian.employee.service;

import com.jalian.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080/microservice-practice/department/", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "MICROSERVICE-DEPARTMENT") //this form is used for auto load balancing
public interface APIClient {

    @GetMapping("/microservice-practice/department/departments/{id}")
    DepartmentDto getDepartment(@PathVariable Long id);
}
