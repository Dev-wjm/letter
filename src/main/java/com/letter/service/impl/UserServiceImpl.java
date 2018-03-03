package com.letter.service.impl;

import com.letter.entity.Users;
import com.letter.repository.UsersRepository;
import com.letter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findOne(String userId) {
        return usersRepository.findUsersById(userId);
    }

    @Override
    public void addOne(Users users) {
        usersRepository.saveAndFlush(users);
    }

    @Override
    public void deleteOne(String id) {
        usersRepository.deleteById(id);
    }

    @Override
    public int updateOne(Users users) {
        usersRepository.saveAndFlush(users);
        return 0;
    }


}
