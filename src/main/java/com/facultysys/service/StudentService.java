package com.facultysys.service;

import com.facultysys.errors.NotFoundException;
import com.facultysys.mapper.Mapper;
import com.facultysys.model.Department;
import com.facultysys.model.Student;
import com.facultysys.modelAndView.StudentModelView;
import com.facultysys.repository.DepartmentRepository;
import com.facultysys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private Mapper mapper;



  public List<StudentModelView> getAllStudent(){
      try {
          var students=studentRepository.findAll();
          var studentModel =students.stream().map(student -> mapper.covertToStudentViewModel(student)).collect(Collectors.toList());
          return  studentModel;
      }catch (NoSuchElementException e){
          throw new NotFoundException("there are not students");
      }

  }

    public List<StudentModelView> getStudentsByState(String state){
        try {
            var students=studentRepository.findByStudStateContains(state);
            var studentModel =students.stream().map(student -> mapper.covertToStudentViewModel(student)).collect(Collectors.toList());
            return  studentModel;
        }catch (NoSuchElementException e){
            throw new NotFoundException("there are not students");
        }

    }


  public StudentModelView getStudentById(int id){
      try{
          var student=studentRepository.findById(id).get();
          var studentModel=mapper.covertToStudentViewModel(student);
          return  studentModel;

      }
      catch (NoSuchElementException e){
          throw new NotFoundException("student not exits");
      }

  }

    public List<StudentModelView> getStudentByPid(String id){

        try {
            var students=studentRepository.findByStudpidContains(id);
            var studentModel =students.stream().map(student -> mapper.covertToStudentViewModel(student)).collect(Collectors.toList());
            return  studentModel;
        }catch (NoSuchElementException e){
            throw new NotFoundException("there are not students");
        }

    }

    public List<StudentModelView> getStudentByNationalId(String id) {

        try {
            var students = studentRepository.findByStudNationalIdContains(id);
            var studentModel = students.stream().map(student -> mapper.covertToStudentViewModel(student)).collect(Collectors.toList());
            return studentModel;
        } catch (NoSuchElementException e) {
            throw new NotFoundException("there are not students");
        }

    }

    public List<StudentModelView> getStudentByDepartment(String name){

        try {
            var department=departmentService.getDepartmentByName(name);
            var students = studentRepository.findByDepartment(department);
            var studentModel = students.stream().map(student -> mapper.covertToStudentViewModel(student)).collect(Collectors.toList());
            return studentModel;
        } catch (NoSuchElementException e) {
            throw new NotFoundException("there are not students");
        }
    }


   public Student addStudent(StudentModelView studentModelView){
      var student=mapper.covertToStudentEntity(studentModelView);
      studentRepository.save(student);
      return student;
   }

   public void deleteStudent(int id){
       try {
           studentRepository.deleteById(id);
       }catch (EmptyResultDataAccessException e){
           throw new NotFoundException("id not found to delete it ");
       }
   }






}
