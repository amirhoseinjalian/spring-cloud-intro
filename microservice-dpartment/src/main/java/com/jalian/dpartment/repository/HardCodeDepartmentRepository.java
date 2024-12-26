package com.jalian.dpartment.repository;

import com.jalian.dpartment.database.HardCodeDatabase;
import com.jalian.dpartment.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HardCodeDepartmentRepository {

    private final List<Department> departments = HardCodeDatabase.getDepartments();

    public Department find(Long id) {
        return departments.stream().filter(department -> department.getId().equals(id)).findFirst().orElse(null);
    }

    public Department save(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return find(department.getId());
    }

    public Department update(Department department) {
        Department d = find(department.getId());
        d.setName(department.getName());
        d.setDescription(department.getDescription());
        d.setName(department.getName());
        d.setCode(department.getCode());
        return find(d.getId());
    }

    public Department delete(Long id) {
        Department d = find(id);
        departments.remove(d);
        return d;
    }

    public List<Department> findAll() {
        return departments;
    }
}
