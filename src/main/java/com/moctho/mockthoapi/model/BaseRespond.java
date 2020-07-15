package com.moctho.mockthoapi.model;

public class BaseRespond<T> {

    public  boolean status;
    public  String  message;
    public  T          data;

    public BaseRespond(T data, boolean status, String message) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseRespond(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
