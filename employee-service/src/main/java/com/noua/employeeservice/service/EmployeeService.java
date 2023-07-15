package com.noua.employeeservice.service;

import com.noua.employeeservice.moodel.Employee;
import com.noua.employeeservice.repository.EmployeeRepository;
import com.noua.employeeservice.vo.Department;
import com.noua.employeeservice.vo.ResponseTemplateVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final RestTemplate restTemplate;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<ResponseTemplateVo> getEmployeeByDepart(Integer id) {
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        List<Employee> employee = employeeRepository.findEmployeeByDepartIdIn(List.of(id));
        Department department = restTemplate.getForObject("http://localhost:8082/department/"+id, Department.class);
        responseTemplateVo.setDepartment(department);
        responseTemplateVo.setEmployee(employee);
        return List.of(responseTemplateVo);
    }

    public List<ResponseTemplateVo> getEmployeeAndDepart() {
        List<ResponseTemplateVo> responseList = new ArrayList<>();

        Department[] departments = restTemplate.getForObject("http://localhost:8082/department", Department[].class);

        for (Department department : departments) {
            ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();

            List<Employee> employees = employeeRepository.findEmployeeByDepartIdIn(List.of(department.getDepartId()));

            responseTemplateVo.setDepartment(department);
            responseTemplateVo.setEmployee(employees);

            responseList.add(responseTemplateVo);
        }

        return responseList;
    }

}
