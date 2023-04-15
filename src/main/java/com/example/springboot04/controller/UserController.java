package com.example.springboot04.controller;

import com.example.springboot04.mapper.UserMapper;
import com.example.springboot04.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    @ResponseBody
    public List<User> queryUser(){
        List<User> users = userMapper.queryAll();
        return users;
    }
}
