package com.exam.service;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.Set;

public interface UserService {


    //creating User
    public User createUser (User user, Set<UserRole> userRoles) throws Exception;

     //gettingUser
    public User getUser(String username);
}
