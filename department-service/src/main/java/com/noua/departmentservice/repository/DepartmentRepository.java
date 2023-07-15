package com.noua.departmentservice.repository;

import com.noua.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findDepartmentByDepartId (Integer departId);
}
