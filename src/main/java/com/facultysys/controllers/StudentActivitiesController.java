package com.facultysys.controllers;


import com.facultysys.model.StudentActivity;
import com.facultysys.service.StudentActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fci")
public class StudentActivitiesController {

    @Autowired
    private StudentActivityService studentActivityService;

    @GetMapping("/public/student-activities")
    public List<StudentActivity> studentActivities(){
        return studentActivityService.getAllActivity();
    }

    @GetMapping("/public/search-activity/{activity}")
    public List<StudentActivity> SearchActivities(@PathVariable String activity){
        return studentActivityService.searchActivity(activity);
    }


    @PostMapping("/admin/add-student-activity")
    public ResponseEntity<StudentActivity> addActivity(@RequestBody StudentActivity studentActivity){

         studentActivityService.addActivity(studentActivity);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/del-student-activity/{id}")
    public ResponseEntity<Void> del(@PathVariable int id){
        studentActivityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
