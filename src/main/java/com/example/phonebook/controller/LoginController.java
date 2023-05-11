package com.example.phonebook.controller;

import com.example.phonebook.entity.LoginForm;
import com.example.phonebook.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
//        // Récupérer les données de login à partir du DTO
//        String name = loginForm.getName();
//        String password = loginForm.getPassword();
//
//        // Vérifier l'authentification et rediriger en conséquence
//        if (authenticate(name, password)) {
//            return "redirect:/auth/profil";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
    }


