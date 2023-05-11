package com.example.phonebook.service;

import com.example.phonebook.entity.User;
import com.example.phonebook.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public  Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

//    public List<User> findAll(){
//        return userRepository.findAll();
//    }
}
