package com.moctho.mockthoapi.controller;


import com.moctho.mockthoapi.model.BaseResponse;
import com.moctho.mockthoapi.model.LoginRequest;
import com.moctho.mockthoapi.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE  , produces = MediaType.APPLICATION_JSON_VALUE )
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(value = "/login")
    public ResponseEntity<BaseResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        BaseResponse response = iLoginService.loginPayLoad(loginRequest);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
