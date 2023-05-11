package com.example.phonebook.controller;

import com.example.phonebook.entity.User;
import com.example.phonebook.entity.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring", uses = {ContactMapper.class})
public interface UserMapper{

    UserDTO userToUserDTO(User user);
}