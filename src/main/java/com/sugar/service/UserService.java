package com.sugar.service;

import com.sugar.infrastructure.dto.UserDto;
import com.sugar.infrastructure.mapper.UserMapper;
import com.sugar.infrastructure.params.LoginParams;
import com.sugar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Service
public class UserService {
    final
    UserRepository userRepository;
    final
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void create(LoginParams loginParams) {
        String password = passwordEncoder.encode(loginParams.getPassword());
    }

    public UserDto getByName(String name) {
        return UserMapper.map(userRepository.findByName(name));
    }
}
