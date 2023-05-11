package com.example.phonebook;

import com.example.phonebook.entity.Contact;
import com.example.phonebook.entity.Role;
import com.example.phonebook.entity.User;
import com.example.phonebook.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class PhoneBookApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder PasswordEncoder;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        User user1 = new User("john",PasswordEncoder.encode("aze"));
//
//        Contact c1 =new Contact("lili","02132578",user1);
//        user1.getContacts().add(c1);
//        Contact c2 =new Contact("lilyt","0274578",user1);
//        user1.getContacts().add(c2);
//        user1.setRoleList(Arrays.asList(new Role("USER")));
//        userRepository.save(user1);
//
//        User user2 = new User("jane",PasswordEncoder.encode("aze"));
//        Contact c3 = new Contact("titi", "02132578", user2);
//        user2.getContacts().add(c3);
//        Contact c4 = new Contact("tityt", "0274578", user2);
//        user2.getContacts().add(c4);
//        user2.setRoleList(Arrays.asList(new Role("ADMIN")));
//        userRepository.save(user2);


    }
}
