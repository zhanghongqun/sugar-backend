package com.sugar.repository.model;

import com.sugar.domain.Entity;
import com.sugar.domain.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 员工
 */
@javax.persistence.Entity
@Table(name = "sugar.user")
@Data
public class UserDo extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openId;

    private String avatar;

    private String username;

    private String password;


    public User map() {
        User user = new User();
        user.setId(id);
        user.setOpenId(openId);
        user.setAvatar(avatar);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

}
