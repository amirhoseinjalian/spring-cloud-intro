package com.jalian.dpartment.service;

import com.jalian.dpartment.entity.Department;
import com.jalian.dpartment.repository.HardCodeDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final HardCodeDepartmentRepository repository;

    @Autowired
    public DepartmentService(HardCodeDepartmentRepository repository) {
        this.repository = repository;
    }

    public Department find(Long id) {
        return repository.find(id);
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    public Department update(Department department) {
        return repository.update(department);
    }

    public Department delete(Long id) {
        return repository.delete(id);
    }

    public List<Department> findAll() {
        return repository.findAll();
    }
}
