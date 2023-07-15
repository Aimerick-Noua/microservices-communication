package com.noua.employeeservice.vo;

import com.noua.employeeservice.moodel.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {
    private Department department;
    private List<Employee> employee;
}
