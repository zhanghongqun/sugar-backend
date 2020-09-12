package com.sugar.infrastructure.mapper;

import com.sugar.domain.User;
import com.sugar.infrastructure.dto.UserDto;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
public class UserMapper {

    public static UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setId(user.getId());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }
}
