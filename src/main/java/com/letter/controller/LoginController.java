package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.LoginEntity;
import com.letter.entity.Users;
import com.letter.service.ILoginService;
import com.letter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginR() {
        return "login";
    }

    @RequestMapping("/login/{type}")
    @ResponseBody
    public LoginEntity login(@PathVariable(name = "type") String type, String openId, String token, Model model){
        LoginEntity login = loginService.login(type,openId,token);
        if (null!=model) {
            model.addAttribute(login);
        }
        return null;
    }

    @RequestMapping("/register")
    @ResponseBody
    public AjaxJsonResult register(@RequestBody LoginEntity login){
        AjaxJsonResult result = new AjaxJsonResult();
        String id = UUID.randomUUID().toString().replace("-","");
        loginService.regsiter(login);
        result.setSuccess(true);
        result.setMessage("注册成功");
        return result;
    }
}
