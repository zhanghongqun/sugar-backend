package com.sugar.controller.task;

import com.sugar.infrastructure.dto.AuthDto;
import com.sugar.infrastructure.dto.ResultDto;
import com.sugar.infrastructure.dto.UserDto;
import com.sugar.infrastructure.params.LoginParams;
import com.sugar.infrastructure.security.jwt.TokenProvider;
import com.sugar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@RestController
@RequestMapping("user")
public class UserController {
    final AuthenticationManagerBuilder authenticationManagerBuilder;
    final TokenProvider tokenProvider;
    final UserService userService;

    @Autowired
    public UserController(AuthenticationManagerBuilder authenticationManagerBuilder, TokenProvider tokenProvider, UserService userService) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @PostMapping("auth")
    public ResultDto auth(@RequestBody LoginParams loginParams) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginParams.getUsername(), loginParams.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        return new ResultDto(AuthDto.builder().token(jwt).build());
    }

    @PostMapping("logout")
    public void logout() {

    }

    @GetMapping
    public UserDto get() {
        return userService.getByName(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
