package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Role;
import com.springAndJava.twitterClone.entity.User;
import com.springAndJava.twitterClone.repository.RoleRepository;
import com.springAndJava.twitterClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("USER").get();

        List<Role> roleSet = new ArrayList<>();
        roleSet.add(role);

        User user =new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRoles(roleSet);

        return userRepository.save(user);

    }

}
