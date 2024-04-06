package com.example.kanbansystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/user").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/addUser").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/boards/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/api/boards").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/boards/**").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                .formLogin()
               // .failureHandler(authenticationFailureHandler())// Set custom authentication failure handler
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService myUserDetailsService() {
        return new MyuserDetailsService();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
