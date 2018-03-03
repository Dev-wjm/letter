package com.letter.service;

import com.letter.entity.LoginEntity;

public interface ILoginService {
    LoginEntity login(String type,String openId,String token);

    int regsiter(LoginEntity login);
}
