package com.levin.mvcdemo.service;

import com.levin.mvcdemo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean login(User user);
}
