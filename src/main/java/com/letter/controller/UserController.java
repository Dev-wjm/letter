package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.LoginEntity;
import com.letter.entity.Users;
import com.letter.service.ILoginService;
import com.letter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ILoginService loginService;

    @RequestMapping("/user/")
    @ResponseBody
    public List<Users> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public Users findOne(@PathVariable(value = "id") String userId){
        return userService.findOne(userId);
    }

    @RequestMapping(value = "/user/add", consumes = "application/json")
    @ResponseBody
    public AjaxJsonResult addOne(@RequestBody Users user){
        AjaxJsonResult result = new AjaxJsonResult();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setCreated(new Date());
        user.setBirthday(new Date());
        LoginEntity login = new LoginEntity();
        login.setId(UUID.randomUUID().toString().replace("-",""));
        login.setOpenId(user.getUsername());
        login.setToken("666666");
        user.setLoginId(login);
        userService.addOne(user);
        result.setSuccess(true);
        result.setMessage("添加成功");
        return result;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxJsonResult deleteOne(@PathVariable(value = "id") String id){
        AjaxJsonResult result = new AjaxJsonResult();
        userService.deleteOne(id);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxJsonResult updateOne(@RequestBody Users user){
        AjaxJsonResult result = new AjaxJsonResult();
        Users users = new Users();
        users = user;
        users.setId(user.getId());
        userService.updateOne(users);
        result.setSuccess(true);
        result.setMessage("更新成功");
        return result;
    }

}
