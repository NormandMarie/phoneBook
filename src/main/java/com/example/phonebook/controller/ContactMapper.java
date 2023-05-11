package com.example.phonebook.controller;

import com.example.phonebook.entity.Contact;
import com.example.phonebook.entity.ContactDTO;
import com.example.phonebook.entity.User;
import com.example.phonebook.entity.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ContactMapper {

    ContactDTO contactToContactDTO(Contact contact);
}
