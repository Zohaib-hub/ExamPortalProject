package com.exam.controllers;


import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("user")
@CrossOrigin ("http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();
         Role role = new Role ();
            role.setRoleId(45L);
            role.setRoleName("NORMAL USER");

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);

            roles.add(userRole);

            return this.userService.createUser(user,roles);
    }


    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }

}
