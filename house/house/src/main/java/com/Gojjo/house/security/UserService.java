package com.Gojjo.house.security;

import java.util.List;

public interface UserService {
    
    public List<User> findAllUsers();

    public void deleteUserById(Long userId);

    public User findUserById(Long id);

    public Object findByUsername(String username);

    public User findUserByUsername(String username);

    public User getUserById(Long id);

}
