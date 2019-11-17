package com.facultysys.repository;

import com.facultysys.model.Department;
import com.facultysys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {

    List<Student> findByStudpidContains(String  id);
    List<Student> findByStudNationalIdContains(String nationalId);
    List<Student> findByStudStateContains(String state);
    List<Student> findByDepartment(Department id);
}
