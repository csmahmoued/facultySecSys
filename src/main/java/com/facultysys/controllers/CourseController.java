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
@CrossOrigin
@RequestMapping("/fci")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/public/all-course")
    public ResponseEntity<List<CourseModelView>> getAll(){

        return new ResponseEntity<>(courseService.getAllCourse(),HttpStatus.OK);
    }

    @PostMapping("/admin/add-course")
    public ResponseEntity<Courses> addCourse(@RequestBody  CourseModelView courseModelView){
        courseService.addCourse(courseModelView);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/public/course/{id}")
    public ResponseEntity<CourseModelView> getC(@PathVariable int id){
        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
    }

    @GetMapping("/public/department-course/{dname}")
    public ResponseEntity<List<CourseModelView>> getdepartmentCourse(@PathVariable String dname){
        return new ResponseEntity<>(courseService.getAllCourseByDepartment(dname), HttpStatus.OK);
    }

    @GetMapping("/public/term-course/{term}")
    public ResponseEntity<List<CourseModelView>> getdepartmentCourseByTerm(@PathVariable String term){
        return new ResponseEntity<>(courseService.getAllCourseByTer(term), HttpStatus.OK);
    }

    @GetMapping("/public/year-course/{year}")
    public ResponseEntity<List<CourseModelView>> getdepartmentCourseByYear(@PathVariable String year){
        return new ResponseEntity<>(courseService.getAllCourseByYear(year), HttpStatus.OK);
    }


    @DeleteMapping("/admin/del-course/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
            courseService.deleteCourese(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
