package com.example.phonebook.controller;

import com.example.phonebook.entity.Contact;
import com.example.phonebook.entity.User;
import com.example.phonebook.repository.ContactRepository;
import com.example.phonebook.repository.UserRepository;
import com.example.phonebook.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class authController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    @GetMapping("/profil")
    public String displayUserDetails(Model model){
        Optional<User> user = Optional.ofNullable(userDetailsServiceImpl.getCurrentUser());

//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByName(username);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            List<Contact> contacts = user.get().getContacts();
            model.addAttribute("contacts", contacts);
            return "profil";
        } else {
            // Gérer l'absence de l'utilisateur
            return "error";
        }
    }

    @GetMapping("/profil/{id}")
    public String displayUserDetails(@PathVariable Long id, Model model){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
        }
        model.addAttribute("user", user.get());

        return "profil_details";
    }
    @PostMapping("/contacts/new")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        Optional<User> user = Optional.ofNullable(userDetailsServiceImpl.getCurrentUser());
//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByName(username);
        if (user.isPresent()) {
            contact.setUser(user.get());
            contactRepository.save(contact);
        } else {
            // Gérer l'absence de l'utilisateur
            return "error";
        }
        return "redirect:/auth/profil";
    }
    @GetMapping("/contacts/{id}/delete")
    public String deleteContact(@PathVariable("id") Long id) {
        Optional<User> user = Optional.ofNullable(userDetailsServiceImpl.getCurrentUser());
//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByName(username);
        if (user.isPresent()) {
            Optional<Contact> contact = contactRepository.findById(id);
            if (contact.isPresent() && contact.get().getUser().equals(user.get())) {
                contactRepository.delete(contact.get());
            }
        }
        return "redirect:/auth/profil";
    }

}
