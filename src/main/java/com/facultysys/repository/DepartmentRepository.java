package com.facultysys.repository;

import com.facultysys.model.Department;
import com.facultysys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department,Integer> {

    Department findByDeptName(String name);

}
