package com.facultysys.repository;

import com.facultysys.model.Courses;
import com.facultysys.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Integer> {

    List<Courses> findByCourseTerm(String name);
    List<Courses> findByDepartment(Department department);
    List<Courses> findByCourseYear(String year);
}
