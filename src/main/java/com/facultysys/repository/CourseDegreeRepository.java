package com.facultysys.repository;

import com.facultysys.model.CourseDegree;
import com.facultysys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDegreeRepository extends JpaRepository<CourseDegree,Integer> {
    List<CourseDegree> findByStudent(Student student);

    @Query(value = "SELECT sum(degree) FROM course_degree where studpid=:id",nativeQuery = true)
    public String GetTotalStudentDegree(int id);
}
