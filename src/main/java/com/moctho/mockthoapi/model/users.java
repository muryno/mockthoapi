package com.moctho.mockthoapi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String phone;
    private String bvn;
    private String first_name;
    private String passwords;


    public users(Integer user_id, String phone, String bvn, String first_name,String passwords) {
        this.user_id = user_id;
        this.phone = phone;
        this.bvn = bvn;
        this.first_name = first_name;
        this.passwords = passwords;
    }

    public users() {
    }

    public Integer getId() {
        return user_id;
    }

    public void setId(Integer id) {
        this.user_id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getPasswords() {
        return passwords;
    }
}
