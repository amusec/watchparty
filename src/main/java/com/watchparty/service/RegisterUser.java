package com.watchparty.service;
import org.springframework.stereotype.Service;
import com.watchparty.model.User;


@Service
public class RegisterUser{
    public String register(User user){
        System.out.println(user.getUsername());      
        return "User Registered";
    }
}