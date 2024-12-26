package com.jalian.employee.repository;

import com.jalian.employee.database.HardCodeDatabase;
import com.jalian.employee.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardCodeEmployeeRepository {

    private final List<Employee> employees = HardCodeDatabase.getEmployees();

    public Employee find(String id) {
        return employees.stream().filter(employee -> employee.getUsername().equals(id)).findFirst().orElse(null);
    }

    public Employee save(Employee employee) {
        employees.add(employee);
        return find(employee.getUsername());
    }

    public Employee update(Employee employee) {
        Employee e = find(employee.getUsername());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        return find(e.getUsername());
    }

    public Employee delete(String id) {
        Employee d = find(id);
        employees.remove(d);
        return d;
    }

    public List<Employee> findAll() {
        return employees;
    }
}
