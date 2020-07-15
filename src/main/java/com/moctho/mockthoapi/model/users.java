package com.moctho.mockthoapi.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity()
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor

public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String phone;
    private String bvn;
    private String first_name;
    private String surname;
    private String dob;

    private String gender;

    private String roles;

    private String password;
    private String image;



    private String token;
    private String otp;
    private String status;
    private String id_type;
    private String id_number;
    private String email;
    private String business_name;
    private String location;
    private String state;
    private String lga;






}
