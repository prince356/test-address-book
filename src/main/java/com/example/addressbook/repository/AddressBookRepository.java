package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
    Optional<AddressBook> findByEmail(String email);
}
