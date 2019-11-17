package com.facultysys.controllers;

import com.facultysys.model.FacultyInfo;
import com.facultysys.service.FacultyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/fci")
public class FacultyInfoController {

    @Autowired
    private FacultyInfoService facultyInfoService;

    @PostMapping("/admin/add-info")
    public ResponseEntity<FacultyInfo> addFacultyInfo(@RequestBody  FacultyInfo facultyInfo){
         facultyInfoService.addFacultyInf(facultyInfo);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/del-fci-info/{id}")
    public ResponseEntity<Void> del(@PathVariable int id){
          facultyInfoService.deleteFacultyInfo(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/public/fci-info/{id}")
    public ResponseEntity<FacultyInfo> getInfo(@PathVariable int id){
        facultyInfoService.getFacultyInfo(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }



}
