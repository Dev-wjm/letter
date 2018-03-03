package com.letter.service;

import com.letter.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();

    Users findOne(String userId);

    void addOne(Users users);

    void deleteOne(String id);

    int updateOne(Users users);
}
