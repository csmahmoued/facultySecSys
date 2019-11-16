package com.facultysys.controllers;

import com.facultysys.model.Staff;
import com.facultysys.model.User;
import com.facultysys.modelAndView.StaffModelView;
import com.facultysys.repository.UserRepository;
import com.facultysys.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private PasswordEncoder p;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all-staff")
    public List<StaffModelView>  StaffAll(){

        return staffService.getAllStaffInfo();
    }

    @GetMapping("/all-staff-type/{type}")
    public List<StaffModelView>  StaffAllByType(String type){
        return staffService.getAllStaffInfoByType(type);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffModelView> getStaff(@PathVariable int id){
        return new ResponseEntity<>(staffService.getStaff(id),HttpStatus.OK);
    }

    @GetMapping("/staff-by-name/{name}")
    public ResponseEntity<StaffModelView> getStaffByName(@PathVariable String name){
        return new ResponseEntity<>(staffService.getStaffByName(name),HttpStatus.OK);
    }

    @PostMapping("/add-staff")
    public ResponseEntity<Staff> addStaff(@RequestBody StaffModelView staffModelView){
        staffService.addStaff(staffModelView);

        User user=new User(staffModelView.getStaffName(),staffModelView.getStaffEmail(),"staff","");
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("del-staff/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        staffService.deleteStaff(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
