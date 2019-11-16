package com.facultysys.service;

import com.facultysys.errors.NotFoundException;
import com.facultysys.mapper.Mapper;
import com.facultysys.model.Courses;
import com.facultysys.modelAndView.CourseModelView;
import com.facultysys.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseModelView> getAllCourse(){
        var courses=courseRepository.findAll();
        var courseModel=courses.stream().map(courses1 -> mapper.convetToCourseViewModel(courses1)).collect(Collectors.toList());
        return courseModel;
    }

    public CourseModelView getCourse(int id){
        try {
            var course=courseRepository.findById(id).get();
            var courseModel=mapper.convetToCourseViewModel(course);
            return courseModel;
        }catch (NoSuchElementException e){
            throw  new NotFoundException("this is id not found");
        }

    }

    public Courses addCourse(CourseModelView courseModelView){
        var course=mapper.covertToCourseEntity(courseModelView);
        courseRepository.save(course);
        return course;
    }

    public void deleteCourese(int id){
        try {
            courseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new NotFoundException("this id not found to delete it");

        }
    }




}
