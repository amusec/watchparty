package com.watchparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


import com.watchparty.model.User;
import com.watchparty.service.UserService;
import java.util.*;


@RestController
public class UserController{
    
    @Autowired
    private UserService userservice;
    
    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody User user){
        return userservice.register(user);
    }
    
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody User user){
        String jwtToken =  userservice.login(user);
        Map<String, Object> response = new HashMap<>();
        if(!jwtToken.equals("N/A")){
            response.put("status",true);
            response.put("token",jwtToken);
        }else{
            response.put("status",true);
            response.put("token",jwtToken);
        }
        return ResponseEntity.ok(response);
    }
    
}