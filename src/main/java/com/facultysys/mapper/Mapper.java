package com.facultysys.mapper;

import com.facultysys.model.CourseDegree;
import com.facultysys.model.Courses;
import com.facultysys.model.Staff;
import com.facultysys.model.Student;
import com.facultysys.modelAndView.CourseModelView;
import com.facultysys.modelAndView.DegreeCourseModelView;
import com.facultysys.modelAndView.StaffModelView;
import com.facultysys.modelAndView.StudentModelView;
import com.facultysys.repository.CourseRepository;
import com.facultysys.repository.DepartmentRepository;
import com.facultysys.repository.StaffRepository;
import com.facultysys.repository.StudentRepository;
import com.facultysys.service.DepartmentService;
import com.facultysys.service.StaffService;
import org.apache.coyote.http11.filters.VoidOutputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private DepartmentRepository departmentService;

    @Autowired
    private StaffRepository staffService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;



    public StudentModelView covertToStudentViewModel(Student student){

        var viewModel=new StudentModelView();
        viewModel.setStudid(String.valueOf(student.getStudid()));
        viewModel.setStudpid(String.valueOf(student.getStudpid()));
        viewModel.setStudNationalId(String.valueOf(student.getStudNationalId()));
        viewModel.setStudName(student.getStudName());
        viewModel.setStudCity(student.getStudCity());
        viewModel.setStudState(student.getStudState());
        viewModel.setStudEmail(student.getStudEmail());
        viewModel.setStudPhone(student.getStudPhone());
        viewModel.setStudbday(student.getStudbday());
        viewModel.setDeptId(String.valueOf(student.getDepartment().getDeptId()));
        return viewModel;
    }


    public CourseModelView convetToCourseViewModel(Courses courses){
        var viewModel=new CourseModelView();
        viewModel.setCourseId(String.valueOf(courses.getCourseId()));
        viewModel.setDeptId(String.valueOf(courses.getDepartment().getDeptId()));
        viewModel.setStaffId(String.valueOf(courses.getStaff().getStaffId()));
        viewModel.setCourseDesc(courses.getCourseDesc());
        viewModel.setCourseLectNo(courses.getCourseLectNo());
        viewModel.setCourseName(courses.getCourseName());
        viewModel.setCourseTerm(courses.getCourseTerm());
        return viewModel;
    }

    public Courses covertToCourseEntity(CourseModelView modelView){

        var department=departmentService.findById(Integer.parseInt(modelView.getDeptId())).get();
        var staff=staffService.findById(Integer.parseInt(modelView.getStaffId())).get();
        var CourseEntity=new Courses();
        CourseEntity.setCourseId(Integer.parseInt(modelView.getCourseId()));

        CourseEntity.setCourseDesc(modelView.getCourseDesc());
        CourseEntity.setCourseName(modelView.getCourseName());
        CourseEntity.setCourseTerm(modelView.getCourseTerm());
        CourseEntity.setCourseYear(modelView.getCourseYear());
        CourseEntity.setDepartment(department);
        CourseEntity.setStaff(staff);
        return CourseEntity;
    }


    public Student covertToStudentEntity(StudentModelView viewModel){

        var department=departmentService.findById(Integer.parseInt(viewModel.getDeptId())).get();
        var studentEnity=new Student();

        studentEnity.setStudid(Integer.parseInt(viewModel.getStudid()));
        studentEnity.setStudpid(Integer.parseInt(viewModel.getStudpid()));
        studentEnity.setStudNationalId(Integer.parseInt(viewModel.getStudNationalId()));
        studentEnity.setStudName(viewModel.getStudName());
        studentEnity.setStudPhone(viewModel.getStudPhone());
        studentEnity.setStudEmail(viewModel.getStudEmail());
        studentEnity.setStudState(viewModel.getStudState());
        studentEnity.setStudCity(viewModel.getStudCity());
        studentEnity.setStudbday(viewModel.getStudbday());
        studentEnity.setDepartment(department);
        return studentEnity;
    }
    public Staff covertStaffToEnity(StaffModelView viewModel){
        var department=departmentService.findById(Integer.parseInt(viewModel.getDeptId())).get();
        var staffEntity=new Staff();
        staffEntity.setDepartment(department);
        staffEntity.setStaffDegree(viewModel.getStaffDegree());
        staffEntity.setStaffName(viewModel.getStaffName());
        staffEntity.setStaffEmail(viewModel.getStaffEmail());
        staffEntity.setStaffPhone(viewModel.getStaffPhone());
        staffEntity.setStaffType(viewModel.getStaffType());
        staffEntity.setStaffId(Integer.parseInt(viewModel.getStaffId()));

        return staffEntity;
    }

    public CourseDegree convertToCourseDegreeEntity(DegreeCourseModelView modelView){

        var course=courseRepository.findById(modelView.getCourseid()).get();
        var student=studentRepository.findById(modelView.getStudpid()).get();
        var degreeEnity=new CourseDegree();
        degreeEnity.setId(modelView.getId());
        degreeEnity.setCourses(course);
        degreeEnity.setStudent(student);
        degreeEnity.setDegree(modelView.getDegree());


        return  degreeEnity;
    }

    public  DegreeCourseModelView coverToDegreeCoursModelView(CourseDegree courseDegree){
        var viewModel=new DegreeCourseModelView();

       viewModel.setId(courseDegree.getId());
       viewModel.setDegree(courseDegree.getDegree());
       viewModel.setStudpid(courseDegree.getStudent().getStudpid());
       viewModel.setCourseid(courseDegree.getCourses().getCourseId());
       viewModel.setCoursename(courseDegree.getCourses().getCourseName());
       viewModel.setMdegree(makeDegree(courseDegree.getDegree()));

        return  viewModel;
    }

    public StaffModelView covertToStaffModelView(Staff staff){
        var viewModel=new StaffModelView();
        viewModel.setDeptId(String.valueOf(staff.getDepartment().getDeptId()));
        viewModel.setStaffDegree(staff.getStaffDegree());
        viewModel.setStaffEmail(staff.getStaffEmail());
        viewModel.setStaffPhone(staff.getStaffPhone());
        viewModel.setStaffDegree(staff.getStaffDegree());
        viewModel.setStaffName(staff.getStaffName());
        viewModel.setStaffType(staff.getStaffType());

        viewModel.setStaffId(String.valueOf(staff.getStaffId()));
        return  viewModel;

    }

    public String makeDegree(double degree){
        if(degree>=65 && degree< 75)
            return "good";
        else if (degree>=75 && degree<= 85)
            return "very good";
        else if(degree>=85)
            return "excelant";
        return "passed";
    }



}
