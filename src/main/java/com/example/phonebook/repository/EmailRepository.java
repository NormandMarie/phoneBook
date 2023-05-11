package com.example.phonebook.repository;

import com.example.phonebook.entity.Contact;
import com.example.phonebook.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository  extends JpaRepository<Email,Long> {
}
