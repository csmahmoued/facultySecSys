package com.facultysys.service;

import com.facultysys.model.FacultyInfo;
import com.facultysys.repository.FacultyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyInfoService {

    @Autowired
    private FacultyInfoRepository fr;

    public FacultyInfo getFacultyInfo(int id){
        return fr.findById(id).get();
    }
    public  FacultyInfo addFacultyInf(FacultyInfo facultyInfo){
        return fr.save(facultyInfo);
    }

    public  void deleteFacultyInfo(int id){
        fr.deleteById(id);
    }



}
