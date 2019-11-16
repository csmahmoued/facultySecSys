package com.facultysys.repository;

import com.facultysys.model.projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<projects,Integer> {

}
