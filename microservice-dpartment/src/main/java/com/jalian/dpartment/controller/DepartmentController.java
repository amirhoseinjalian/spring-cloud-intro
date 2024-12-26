package com.jalian.dpartment.controller;

import com.jalian.dpartment.dto.DepartmentDto;
import com.jalian.dpartment.entity.Department;
import com.jalian.dpartment.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto departmentDto) {
        return ResponseEntity.ok(
                modelMapper.map(
                        service.save(modelMapper.map(departmentDto, Department.class)), DepartmentDto.class
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(service.find(id), DepartmentDto.class));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return ResponseEntity.ok(modelMapper.map(service.findAll(), List.class));
    }
}
