package com.facultysys.service;

import com.facultysys.errors.NotFoundException;
import com.facultysys.model.Department;
import com.facultysys.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService  {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return  departmentRepository.findAll();
    }

    public Department getDepartment(int id){

       try {
           return departmentRepository.findById(id).get();
       }catch (Exception e){
           throw new NotFoundException("id : "+id+" not found");
       }

    }

    public Department getDepartmentByName(String deptName){

        try {
            return departmentRepository.findByDeptName(deptName);
        }catch (Exception e){
            throw new NotFoundException("department not found ");
        }

    }


    public Department addDepartment(Department department){
        return  departmentRepository.save(department);
    }

    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

}
