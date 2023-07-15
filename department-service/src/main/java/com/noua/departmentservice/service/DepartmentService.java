package com.noua.departmentservice.service;

import com.noua.departmentservice.model.Department;
import com.noua.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findDepartmentByDepartId(id);
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }
}
