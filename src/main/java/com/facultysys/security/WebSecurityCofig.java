package com.facultysys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityCofig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserPerncipalService userPerncipalService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPerncipalService);
        return daoAuthenticationProvider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers( "/fci/degree/student/**").hasAnyRole("student","admin")
                .antMatchers( "/fci/admin/**").hasRole("admin")
                .antMatchers( "/fci/staff/admin/**").hasRole("admin")
                .antMatchers( "/fci/depart/admin/**").hasRole("admin")
                .antMatchers( "/fci/degree/admin/**").hasRole("admin")

                .antMatchers( "/fci/public/**").permitAll()
                .antMatchers( "/fci/staff/public/**").permitAll()
                .antMatchers( "/fci/depart/public/**").permitAll()
                .antMatchers( "/fci/student/public/**").permitAll()

                .and()
                .csrf().disable()
                .formLogin().disable();
    }



}