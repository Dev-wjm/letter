package com.letter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_user")
public class Users implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private Integer age;
    @Column(name = "descs")
    private String desc;
    @Column(name = "created")
    private Date created;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private LoginEntity loginId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LoginEntity getLoginId() {
        return loginId;
    }

    public void setLoginId(LoginEntity loginId) {
        this.loginId = loginId;
    }
}
