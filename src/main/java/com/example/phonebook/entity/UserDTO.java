package com.example.phonebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {


    private Long id;


    private String name;



   private List<Contact> contacts ;

}
