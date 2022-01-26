package com.Gojjo.house.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceHandler implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> userResponse = userRepository.findById(id);
        User user = null;
        if(userResponse.isPresent()){
            user = userResponse.get();
        }else{
            throw new RuntimeException("User with id " + id + "does not exist.");
        }
        return user;
        
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public User getUserById(Long id) {
        
        return userRepository.findById(id).orElse(null);
    }

}
