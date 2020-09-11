package com.brasilprev.BrasilPrev;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/addclient").permitAll()
        .antMatchers(HttpMethod.GET, "/clients").permitAll()
        .antMatchers(HttpMethod.GET,"/client/**").permitAll()
        .antMatchers(HttpMethod.PUT,"/updateclient/*").permitAll()
        .antMatchers(HttpMethod.DELETE,"/client/*").permitAll()
        .anyRequest().authenticated();
    }

}
