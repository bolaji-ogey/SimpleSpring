/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.service;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import i.ogeyingbo.simplespring.entities.User;
import i.ogeyingbo.simplespring.repository.UserRepository;

@Service
public class UserService {
    
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
    
    
    
    
}