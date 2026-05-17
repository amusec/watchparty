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
            response.put("success",true);
            response.put("message","Logged In Successfully!");
            response.put("token",jwtToken);
        }else{
            response.put("success",false);
            response.put("message","LogIn Failed!");
        }
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/api/verify")
    public ResponseEntity<?> verify(@RequestBody Map <String, String> body){
        
        boolean isValid = userservice.validateToken(body.get("token"));
        int code = 200;
        Map<String, Object> response = new HashMap<>();
        if(isValid){
            response.put("success",true);
        }else{
            response.put("success",false);
            code = 401;
        }
        return ResponseEntity.status(code).body(response);
        
    }
    
    
    
}