package com.facultysys.controllers;

import com.facultysys.model.Courses;
import com.facultysys.modelAndView.CourseModelView;
import com.facultysys.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all-course")
    public ResponseEntity<List<CourseModelView>> getAll(){

        return new ResponseEntity<>(courseService.getAllCourse(),HttpStatus.OK);
    }

    @PostMapping("/add-course")
    public ResponseEntity<Courses> addCourse(@RequestBody  CourseModelView courseModelView){
        courseService.addCourse(courseModelView);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseModelView> getC(@PathVariable int id){

        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
    }

    @DeleteMapping("/del-course/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
            courseService.deleteCourese(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
