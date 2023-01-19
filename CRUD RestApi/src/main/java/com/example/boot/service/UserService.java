package com.example.boot.service;

import com.example.boot.model.UserDTO;

public interface UserService {

    UserDTO getUserByEmail(String email);

    UserDTO createUser(UserDTO param);

    UserDTO updateUser(Long id, UserDTO param);

    String deleteUser(Long id);
}
