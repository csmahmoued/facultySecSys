package com.facultysys.repository;

import com.facultysys.model.CourseDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDegreeRepository extends JpaRepository<CourseDegree,Integer> {
}
