package com.facultysys.service;

import com.facultysys.errors.NotFoundException;
import com.facultysys.mapper.Mapper;
import com.facultysys.model.Staff;
import com.facultysys.modelAndView.StaffModelView;
import com.facultysys.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private Mapper mapper;

    public List<StaffModelView> getAllStaffInfo(){
        var staff=staffRepository.findAll();
        var staffModel=staff.stream().map(st ->mapper.covertToStaffModelView(st)).collect(Collectors.toList());
        return staffModel;
    }

    public List<StaffModelView> getAllStaffInfoByType(String type ){
        try {
            var staff=staffRepository.findByStaffTypeContains(type);
            var staffModel=staff.stream().map(st ->mapper.covertToStaffModelView(st)).collect(Collectors.toList());
            return staffModel;

        }catch (NoSuchElementException e){
            throw new NotFoundException("there are not staff");
        }

    }




    public StaffModelView getStaff(int id){
        try {
            var staff=staffRepository.findById(id).get();
            var staffModel=mapper.covertToStaffModelView(staff);
            return staffModel;
        }catch (NoSuchElementException e){
            throw new NotFoundException("id not found ");
        }
    }

    public StaffModelView getStaffByName(String name){
        try {
            var staff=staffRepository.findByStaffNameContains(name);
            var staffModel=mapper.covertToStaffModelView(staff);
            return staffModel;
        }catch (NoSuchElementException e){
            throw new NotFoundException("id not found ");
        }
    }


    public Staff addStaff(StaffModelView staff){
        var st=mapper.covertStaffToEnity(staff);
        staffRepository.save(st);
        return st;
    }

    public void deleteStaff(int id){
        try {
            staffRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new NotFoundException("id not found to delete it ");
        }
    }
}
