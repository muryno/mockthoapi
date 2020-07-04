package com.moctho.mockthoapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class configsApplication extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public configsApplication (PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }





    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails ana= User.builder()
                .username("ana")
                .password(passwordEncoder.encode("123456"))
                .roles("Student")
                .build();

        return new InMemoryUserDetailsManager(
                ana
        );
    }
}
