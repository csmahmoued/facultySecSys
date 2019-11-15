package com.facultysys.security;

import com.facultysys.model.User;
import com.facultysys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestC {

    @Autowired
    private PasswordEncoder p;
    @Autowired
    private UserRepository ur;


    @GetMapping("/")
    public String test(){
        User u=new User("mahmoud",p.encode("password"),"ADMIN","");
        ur.save(u);



        return  "faculty system mangement ";
    }

    @GetMapping("/profile")
    public String getprofile(){
        return "profile ...destintain";
    }

}
