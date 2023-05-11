package com.example.phonebook.controller;

import com.example.phonebook.entity.User;
import com.example.phonebook.entity.UserDTO;
import com.example.phonebook.repository.UserRepository;
import com.example.phonebook.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class ControllerApiUser {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> specificUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        UserDTO userDTO = userMapper.userToUserDTO(user.get());
        return ResponseEntity.ok(userDTO);
    }
}
