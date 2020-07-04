package com.moctho.mockthoapi.controller;


import com.moctho.mockthoapi.model.users;
import com.moctho.mockthoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/add")
    public users CreateUsers(@RequestBody final users session){
        return  userRepository.save(session);
    }

    @GetMapping()
    public List<users> getSession(){
        return userRepository.findAll();
    }

    public static final List<users> USRS = Arrays.asList(
            new users(1,"08091919191","33848448493","adeyemi",""),
            new users(2,"08033212334","34848494494","imo","")

    );

    @GetMapping()
    @RequestMapping(path = "/{userID}")
    public users getUser(@PathVariable Integer userID){



        return USRS.stream().filter(
            it->  userID.equals(it.getId())
        ).findFirst()
                .orElseThrow(()-> new IllegalArgumentException("User with id "+ userID+ "  does  not exist"));
    }
}
