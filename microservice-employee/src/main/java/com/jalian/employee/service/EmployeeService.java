package com.jalian.employee.service;

import com.jalian.employee.entity.Employee;
import com.jalian.employee.repository.HardCodeEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final HardCodeEmployeeRepository repository;

    @Autowired
    public EmployeeService(HardCodeEmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee find(String id) {
        return repository.find(id);
    }

    public Employee save(Employee department) {
        return repository.save(department);
    }

    public Employee update(Employee department) {
        return repository.update(department);
    }

    public Employee delete(String id) {
        return repository.delete(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }
}
