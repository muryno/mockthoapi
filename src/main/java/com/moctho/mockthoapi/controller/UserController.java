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
@RequestMapping(value = "/api-user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/add")
    public ResponseEntity<BaseRespond<users>> CreateUsers(@RequestBody final users session){

        BaseRespond<users> bas =  new BaseRespond<>(    userRepository.save(session),true,"success");
        return  new ResponseEntity<BaseRespond<users>>(bas , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseRespond<users>> getUser(@PathVariable String id){
            users urs = userRepository.findUsersByBvn(id);
                 BaseRespond<users> bas =  new BaseRespond<>(urs,true,"success");
            return  new ResponseEntity<BaseRespond<users>>(bas , HttpStatus.OK);

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
