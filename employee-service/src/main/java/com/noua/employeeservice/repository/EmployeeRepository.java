package com.noua.employeeservice.repository;

import com.noua.employeeservice.moodel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findEmployeeById (Integer id);
    List<Employee> findEmployeeByDepartIdIn(List<Integer> departId);
    Employee findEmployeeByDepartId(Integer departId);
}
