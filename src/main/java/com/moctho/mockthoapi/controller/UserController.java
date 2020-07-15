package com.moctho.mockthoapi.controller;


import com.moctho.mockthoapi.model.BaseRespond;
import com.moctho.mockthoapi.model.users;
import com.moctho.mockthoapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/add")
    public users CreateUsers(@RequestBody final users session){
        return  userRepository.save(session);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseRespond<users>> getUser(@PathVariable(value = "id") Long id){
            users urs = userRepository.getOne(id);
                 BaseRespond<users> bas =  new BaseRespond<>(urs,true,"success");
            return  new ResponseEntity<>(bas , HttpStatus.OK);

    }

    @PostMapping("/add/bvn")
    public ResponseEntity<BaseRespond<Void>> addUsers(@RequestBody users users){
        userRepository.saveAndFlush(users);
        BaseRespond<Void> bas =  new BaseRespond<>(true,"success");
        return  new ResponseEntity<>(bas , HttpStatus.OK);
    }

    @RequestMapping(value = "/update/user/info/{id}",method = RequestMethod.PUT)
    public ResponseEntity<BaseRespond<users>> updateSpeaker(@PathVariable Long id , @RequestBody users speaker){
        users existingSpeaker = userRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"id");

        users resul = userRepository.saveAndFlush(existingSpeaker);
        BaseRespond<users> bas =  new BaseRespond<>(resul,true,"success");
        return  new ResponseEntity<>(bas , HttpStatus.OK);
    }




}
