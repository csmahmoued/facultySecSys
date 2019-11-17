package com.facultysys.controllers;

import com.facultysys.model.Department;
import com.facultysys.model.Student;
import com.facultysys.model.User;
import com.facultysys.modelAndView.StudentModelView;
import com.facultysys.repository.DepartmentRepository;
import com.facultysys.repository.StudentRepository;
import com.facultysys.repository.UserRepository;
import com.facultysys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fci/admin")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder p;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/all-student")
    public ResponseEntity<List<StudentModelView>> AllStudents(){
        return  new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
    }

    @GetMapping(value = "/all-student-state/{state}")
    public ResponseEntity<List<StudentModelView>> AllStudentsState(@PathVariable String state){
        return  new ResponseEntity<>(studentService.getStudentsByState(state),HttpStatus.OK);
    }

    @GetMapping(value = "/all-student-department/{depart}")
    public ResponseEntity<List<StudentModelView>> getStudentInDepartment(@PathVariable String depart){
        if(studentService.getStudentByDepartment(depart)==null)
            return new ResponseEntity("there is no student in this department",HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(studentService.getStudentByDepartment(depart),HttpStatus.OK);
    }



    @GetMapping(value = "/student/{id}")
    public ResponseEntity<StudentModelView> getStudent(@PathVariable int id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/studentby-pid/{pid}")
    public ResponseEntity<List<StudentModelView>> getStudentByState(@PathVariable String pid){
        return new ResponseEntity<>(studentService.getStudentByPid(pid),HttpStatus.OK);
    }

    @GetMapping(value = "/studentby-nationalid/{nationalId}")
    public ResponseEntity<List<StudentModelView>> StudentByNationalId(@PathVariable String nationalId){
        return new ResponseEntity<>(studentService.getStudentByNationalId(nationalId),HttpStatus.OK);
    }

    @PostMapping(value = "/add-student")
    public ResponseEntity<Student> addStud(@Valid @RequestBody StudentModelView studentModelView){
        User user=new User(studentModelView.getStudName(),p.encode(studentModelView.getStudpid()),"student","");
        userRepository.save(user);
        studentService.addStudent(studentModelView);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/del-student/{id}")
    public ResponseEntity<Void> delStudent(@PathVariable int id)
    {   studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
