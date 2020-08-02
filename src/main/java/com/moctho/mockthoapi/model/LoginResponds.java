package com.moctho.mockthoapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponds {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("phone")
    private String PhoneNumber;

    @JsonProperty("password_reset_token")
    private String passwordResetToken;

    @JsonProperty("role")
    private String role;

    @JsonProperty("truck_no")
    private String truckNumber;



}
