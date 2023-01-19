package com.example.boot.service;

import com.example.boot.entity.User;
import com.example.boot.exception.DataNotFoundException;
import com.example.boot.model.UserDTO;
import com.example.boot.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDTO result = new UserDTO();
        User entity = userRepository.findByEmail(email);
        if(entity == null) {
            throw new DataNotFoundException("User not found");
        }
        return maptoDTO(entity, result);
    }

    @Override
    public UserDTO createUser(UserDTO param) {
        User userNew = new User();
        User userSave = userRepository.save(maptoEntity(param,userNew));
        return maptoDTO(userSave, param);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO param) {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        param.setId(user.getId());
        user = userRepository.save(maptoEntity(param, user));
        return maptoDTO(user, param);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        userRepository.delete(user);
        return "Delete Success";
    }

    private UserDTO maptoDTO(User entity, UserDTO dto){
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private User maptoEntity(UserDTO dto, User entity){
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
