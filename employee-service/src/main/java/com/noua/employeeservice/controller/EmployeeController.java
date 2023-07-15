package com.noua.employeeservice.controller;

import com.noua.employeeservice.moodel.Employee;
import com.noua.employeeservice.service.EmployeeService;
import com.noua.employeeservice.vo.ResponseTemplateVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> employeeList(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/department/{id}")
    public List<ResponseTemplateVo> getEmployeeByDepart(@PathVariable Integer id){
        return employeeService.getEmployeeByDepart(id);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

}
