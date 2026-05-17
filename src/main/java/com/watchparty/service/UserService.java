package com.watchparty.service;

import java.util.Map;
import java.util.HashMap;


import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.watchparty.model.User;
import com.watchparty.service.JwtService;


@Service
public class UserService{
    
    @Autowired
    private JdbcTemplate jdbctemplate;
    public ResponseEntity<Map<String,Object>> register(User user){
        Map<String, Object> response = new HashMap<>();
        String sql = "Insert into users(username,email, password) values (?,?,?)";
        try{
            int rows = jdbctemplate.update(sql,user.getUsername(), user.getEmail(), user.getPassword());
            if(rows == 1){
                response.put("success",true);
                response.put("message","User created Successfully");
                return ResponseEntity.ok(response);
            }
            else{
                response.put("success",false);
                response.put("message","User creation failed!");
                return ResponseEntity.ok(response);
                
            }
        }catch(DuplicateKeyException e){
            response.put("success",false);
            response.put("message","Username or email already exists. Please retry!");
            return ResponseEntity.ok(response);
        }catch(DataAccessException e){
            response.put("success",false);
            response.put("message","Database error!");
            return ResponseEntity.ok(response);
        }
    }
    
    public String login(User user){
        Map <String, Object> response = new HashMap<>();
        String sql = "Select count(*) from users where username=? and password=?";
        Integer count = jdbctemplate.queryForObject(sql,Integer.class, user.getUsername(),user.getPassword());
        
        if(count == 1){
            JwtService service = new JwtService();
            return service.generateToken(user.getUsername());
        }
        
        return "N/A";
        
    }
    
    
    
}