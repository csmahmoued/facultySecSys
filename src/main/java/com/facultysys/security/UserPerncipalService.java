package com.facultysys.security;

import com.facultysys.model.User;
import com.facultysys.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPerncipalService implements UserDetailsService {


    private UserRepository userRepository;

    public UserPerncipalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        UserPerncipal userPerncipal=new UserPerncipal(user);
        return  userPerncipal;
    }
}
