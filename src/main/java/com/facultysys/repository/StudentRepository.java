package com.facultysys.repository;

import com.facultysys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {

    Student findByStudpid(int  id);
    Student findByStudNationalId(int nationalId);
    List<Student> findByStudState(String state);
}
