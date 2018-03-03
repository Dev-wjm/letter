package com.letter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_login")
public class LoginEntity implements Serializable{
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "type")
    private String type;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "token")
    private String token;
    @OneToOne(mappedBy = "loginId")
    private Users usersId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }
}
