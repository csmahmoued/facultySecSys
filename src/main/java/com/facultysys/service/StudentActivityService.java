package com.facultysys.service;

import com.facultysys.model.StudentActivity;
import com.facultysys.repository.StudentActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentActivityService {

    @Autowired
    private StudentActivityRepository sp;

    public List<StudentActivity> getAllActivity(){
        return  sp.findAll();
    }

    public StudentActivity getActivity(int id){
        return  sp.findById(id).get();
    }

    public List<StudentActivity> searchActivity(String activity){
        return sp.findByActivityDescIsLike(activity);
    }
    public StudentActivity addActivity(StudentActivity studentActivity){
        return sp.save(studentActivity);
    }

    public void deleteActivity(int id){
        sp.deleteById(id);
    }

}
