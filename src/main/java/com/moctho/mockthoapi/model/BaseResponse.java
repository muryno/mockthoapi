package com.moctho.mockthoapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BaseResponse {

    @JsonProperty("error")
    public  boolean error;

    @JsonProperty("message")
    public  String  message;

    @JsonProperty("data")
    public  LoginResponds     data;



}
