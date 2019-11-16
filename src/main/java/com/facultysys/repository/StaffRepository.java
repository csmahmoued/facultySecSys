package com.facultysys.repository;

import com.facultysys.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

    List<Staff> findByStaffType(String type);
    Staff findByStaffName(String name);



}
