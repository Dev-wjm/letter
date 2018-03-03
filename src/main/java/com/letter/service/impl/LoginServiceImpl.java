package com.letter.service.impl;

import com.letter.entity.LoginEntity;
import com.letter.repository.LoginRepository;
import com.letter.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public LoginEntity login(String type, String openId, String token) {
        return loginRepository.login(type,openId,token);
    }

    @Override
    public int regsiter(LoginEntity login) {
        loginRepository.save(login);
        return 0;
    }
}
