package com.watchparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.watchparty.model.User;
import com.watchparty.service.RegisterUser;
import java.util.*;


@RestController
public class RegisterController{
    
    @Autowired
    private RegisterUser registeruser;
    
    @PostMapping("/api/register")
    public String register(@RequestBody User user){
        return registeruser.register(user);
    }
}