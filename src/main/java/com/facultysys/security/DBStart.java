package com.facultysys.security;

import com.facultysys.model.User;
import com.facultysys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBStart implements CommandLineRunner {

    @Autowired
    private UserRepository us;

    @Autowired
    private PasswordEncoder p;

    @Override
    public void run(String... args) throws Exception {

        //User user =new User("admin",p.encode("admin"),"admin","");
        //us.save(user);


    }
}
