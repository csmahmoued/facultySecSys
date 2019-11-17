package com.facultysys.repository;

import com.facultysys.model.StudentActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentActivityRepository extends JpaRepository<StudentActivity,Integer> {

    List<StudentActivity> findByActivityDescIsLike(String activity);
}
