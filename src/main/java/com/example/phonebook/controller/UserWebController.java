package com.example.phonebook.controller;

import com.example.phonebook.entity.User;
import com.example.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UserWebController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user-details/{id}")
    public String dispalyUserDetails(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
        }
        model.addAttribute("user", user.get());
        return " user_details";
    }
}
