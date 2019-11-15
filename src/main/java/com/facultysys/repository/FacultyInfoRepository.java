package com.facultysys.repository;

import com.facultysys.model.FacultyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyInfoRepository  extends JpaRepository<FacultyInfo,Integer> {
}
