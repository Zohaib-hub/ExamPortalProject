package com.exam.serviceimpl;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
       User local = this.userRepository.findByUsername(user.getUsername());
       if (local!=null){
           System.out.println("User is already there");
           throw new Exception("User already Present");
       } else {
           //createUser
            for (UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
       }
        return local;
    }
    //gettingUserByUserName
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }
}
