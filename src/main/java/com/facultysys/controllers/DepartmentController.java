package com.facultysys.controllers;

import com.facultysys.model.Department;
import com.facultysys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fci/depart")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/public/all-department")
    public List<Department> AllDepartment(){

        return departmentService.getAllDepartment();
    }

    @GetMapping("/public/department/{id}")
    public ResponseEntity<Department> getDept(@PathVariable int id){
        return new ResponseEntity<>(departmentService.getDepartment(id),HttpStatus.OK) ;
    }

    @PostMapping("/admin/add-department")
    public ResponseEntity<Department> addDept(@Valid @RequestBody  Department department){
        departmentService.addDepartment(department);
        return new ResponseEntity<>(HttpStatus.CREATED) ;
    }

    @DeleteMapping("/admin/del-department/{id}")
    public  ResponseEntity<Void> delDept(@PathVariable int id){
        departmentService.deleteDepartment(id);
       return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ;
    }

}
