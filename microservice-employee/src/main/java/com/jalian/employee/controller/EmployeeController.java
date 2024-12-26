package com.jalian.employee.controller;

import com.jalian.employee.dto.DepartmentDto;
import com.jalian.employee.dto.EmployeeDto;
import com.jalian.employee.dto.OrganizationDto;
import com.jalian.employee.entity.Employee;
import com.jalian.employee.service.APIClient;
import com.jalian.employee.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(EmployeeDto employeeDto) {
        return ResponseEntity.ok(
                modelMapper.map(
                        service.save(
                                modelMapper.map(employeeDto, Employee.class)
                        ),
                        EmployeeDto.class
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(modelMapper.map(service.find(id), EmployeeDto.class));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(modelMapper.map(service.findAll(), List.class));
    }

    @GetMapping("department-rest-template/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByRestTemplate(@PathVariable("id") String id) {
        Employee employee = service.find(id);
        return ResponseEntity.ok(
                restTemplate.getForObject(
                        "http://localhost:8080/microservice-practice/department/departments/" + employee.getDepartmentId()
                        , DepartmentDto.class
                )
        );
    }

    @GetMapping("department-web-client/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByWebClient(@PathVariable("id") String id) {
        Employee employee = service.find(id);
        return ResponseEntity.ok(
                webClient.get().uri(
                        "http://localhost:8080/microservice-practice/department/departments/" + employee.getDepartmentId()
                ).retrieve().bodyToMono(DepartmentDto.class).block()
        );
    }

    @GetMapping("organization-web-client/{id}")
    public ResponseEntity<OrganizationDto> getOrganizationByWebClient(@PathVariable("id") String orgId) {
        return ResponseEntity.ok(
                webClient.get().uri(
                        "http://localhost:8083/organizations/find-by-id/" + orgId
                ).retrieve().bodyToMono(OrganizationDto.class).block()
        );
    }

    @GetMapping("department-open-feign/{id}")
    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public ResponseEntity<DepartmentDto> getDepartmentByOpenFeign(@PathVariable("id") String id) {
        logger.info("inside getDepartmentByOpenFeign method");
        return ResponseEntity.ok(apiClient.getDepartment(service.find(id).getDepartmentId()));
    }

    public ResponseEntity<DepartmentDto> getDefaultDepartment(String id, Exception e) {
        logger.info("inside getDefaultDepartment method");
        return ResponseEntity.ok(
                new DepartmentDto(0L, "circuit breaker", "test circuit breaker", "CB Test")
        );
    }
}
