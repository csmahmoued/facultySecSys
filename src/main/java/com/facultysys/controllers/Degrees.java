package com.facultysys.controllers;

import com.facultysys.model.CourseDegree;
import com.facultysys.model.Student;
import com.facultysys.model.User;
import com.facultysys.modelAndView.DegreeCourseModelView;
import com.facultysys.repository.CourseDegreeRepository;
import com.facultysys.repository.UserRepository;
import com.facultysys.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/fci/degree")
public class Degrees {

    @Autowired
    private DegreeService degreeService;

    @GetMapping("/admin/all-degrees")
    public List<DegreeCourseModelView> getall(){

        return degreeService.getAllDegree();
    }

    @GetMapping("/student/student-degree/{id}")
    public ResponseEntity<List<DegreeCourseModelView>> studentDegrees(@PathVariable int id){
         Student  student =new Student(id);
        return new ResponseEntity<>(degreeService.getStudentDegree(student),HttpStatus.OK) ;
    }
    @GetMapping("/student/student-total-degree/{id}")
    public String getTotalDegree(@PathVariable int id){
        return degreeService.getStudentTotalDegree(id);
    }

    @PostMapping("/admin/add-degree")
    public ResponseEntity<CourseDegree> addDegrees(@RequestBody DegreeCourseModelView degreeCourseModelView){
        degreeService.addDegree(degreeCourseModelView);

        return new ResponseEntity<CourseDegree>(HttpStatus. CREATED);
    }

    @DeleteMapping("/admin/del-degree/{id}")
    public ResponseEntity<Void> delDegree(@PathVariable int id){
        degreeService.deleteCourseDegree(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
