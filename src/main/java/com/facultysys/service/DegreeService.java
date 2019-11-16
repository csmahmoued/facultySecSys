package com.facultysys.service;

import com.facultysys.errors.NotFoundException;
import com.facultysys.mapper.Mapper;
import com.facultysys.model.CourseDegree;
import com.facultysys.model.Student;
import com.facultysys.modelAndView.DegreeCourseModelView;
import com.facultysys.repository.CourseDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DegreeService {

    @Autowired
    private CourseDegreeRepository courseDegreeRepository;
    @Autowired
    private Mapper mapper;

    public String getStudentTotalDegree(int id){
        return courseDegreeRepository.GetTotalStudentDegree(id);
    }
    public List<DegreeCourseModelView> getAllDegree(){
        var degree=courseDegreeRepository.findAll();
        var courseDegree=degree.stream().map(courseDegree1 -> mapper.coverToDegreeCoursModelView(courseDegree1)).collect(Collectors.toList());
        return courseDegree;
    }

    public List<DegreeCourseModelView> getStudentDegree(Student student){
        var degree=courseDegreeRepository.findByStudent(student);
        var courseDegree=degree.stream().map(courseDegree1 -> mapper.coverToDegreeCoursModelView(courseDegree1)).collect(Collectors.toList());
        return courseDegree;
    }


    public DegreeCourseModelView getderees(int id){
       try {
           var m=courseDegreeRepository.findById(id).get();
           var degree=mapper.coverToDegreeCoursModelView(m);
           return  degree;
       }catch (NoSuchElementException e){
           throw new NotFoundException("no degrees found ");
       }
    }




    public CourseDegree addDegree(DegreeCourseModelView modelView){
        var d=mapper.convertToCourseDegreeEntity(modelView);
        courseDegreeRepository.save(d);
        return d;
    }

    public void deleteCourseDegree(int id){
        courseDegreeRepository.deleteById(id);
    }





}
