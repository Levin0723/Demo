package com.levin.mvcdemo.service;


import com.levin.mvcdemo.model.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    public boolean login(User user) {
        if (user.getUsername().equals("admin")){
            if (user.getPassword().equals("12345")){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
