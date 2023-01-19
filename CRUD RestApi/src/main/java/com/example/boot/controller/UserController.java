package com.example.boot.controller;

import com.example.boot.model.UserDTO;
import com.example.boot.response.ResponseBody;
import com.example.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ResponseBody> getUserByEmail(@RequestParam String email){
        UserDTO user = userService.getUserByEmail(email);
        return ResponseEntity.ok(new ResponseBody<>("200","",user));
    }

    @PostMapping
    public ResponseEntity<ResponseBody> createUser(@RequestBody UserDTO request){
        UserDTO user = userService.createUser(request);
        return new ResponseEntity(new ResponseBody<>("200","",user), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseBody> updateUser(@PathVariable("userId") Long userId,
                                                   @RequestBody UserDTO dto ){
        UserDTO user = userService.updateUser(userId, dto);
        return new ResponseEntity(new ResponseBody<>("200","",user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseBody> deleteUser(@PathVariable("userId") Long userId){
        String response = userService.deleteUser(userId);
        return new ResponseEntity(new ResponseBody<>("200","",response), HttpStatus.OK);
    }

}
