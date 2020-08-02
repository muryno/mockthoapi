package com.moctho.mockthoapi.service;

import com.moctho.mockthoapi.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NoHttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService implements  ILoginService {


    private  RestTemplate restTemplate = new RestTemplate();

    @Override
    public BaseResponse loginPayLoad(@NotBlank(message = "request parameter can't be empty or blank") LoginRequest loginRequest) {



        String validatorUrl = "https://alt360backend.herokuapp.com/user/login";
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("email", loginRequest.getEmail());
        form.add("password", loginRequest.getPassword());



        HttpEntity<MultiValueMap<String, Object>> reqEntity = new HttpEntity<>(form, headers);

       // HttpEntity<LoginRequest> reqEntity = new HttpEntity<>(loginRequest, headers);

        //sending request to client api




            ResponseEntity<BaseResponse> response = restTemplate.exchange(validatorUrl, HttpMethod.POST, reqEntity, BaseResponse.class);


            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            } else {
                return response.getBody();
            }








    }
}
