package com.moctho.mockthoapi.service;

import com.moctho.mockthoapi.model.BaseResponse;
import com.moctho.mockthoapi.model.LoginRequest;
import com.moctho.mockthoapi.model.LoginResponds;


public interface ILoginService {
    BaseResponse loginPayLoad (LoginRequest loginRequest);
}
