package com.noua.departmentservice.controller;

import com.noua.departmentservice.model.Department;
import com.noua.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping
    public List<Department> departmentList(){
        return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id){
        return departmentService.getDepartmentById(id);
    }
    @PostMapping
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }
}
