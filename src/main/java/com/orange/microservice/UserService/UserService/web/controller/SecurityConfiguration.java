package com.orange.microservice.UserService.UserService.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;  
@Configuration  

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	public void configure(HttpSecurity http) throws Exception {  
        http.csrf().disable().cors().and().headers().frameOptions().disable().and()
            .authorizeRequests()  
            .anyRequest().authenticated()  
            .and()  
            .httpBasic();  
	}
	 
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
	        auth.inMemoryAuthentication() 
	            .withUser("user")
	            .password("{noop}pass") // Spring Security 5 requires specifying the password storage format  
	            .roles("USER");
	    }  
}
