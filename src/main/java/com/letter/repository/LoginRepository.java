package com.letter.repository;

import com.letter.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Integer>{

    @Query("select u from LoginEntity u where u.type=?1 and u.openId=?2 and u.token=?3")
    LoginEntity login(String type,String openId,String token);

}
