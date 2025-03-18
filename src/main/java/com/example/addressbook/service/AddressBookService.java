package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressBookService {

    private final List<AddressBook> contacts = new ArrayList<>();
    private int idCounter = 1;

    public List<AddressBook> getAllContacts() {
        log.info("Fetching all contacts...");
        return new ArrayList<>(contacts);
    }

    public Optional<AddressBook> getContactById(int id) {
        log.info("Fetching contact with ID: {}", id);
        return contacts.stream().filter(contact -> contact.getId() == id).findFirst();
    }

    public AddressBook createContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(idCounter++, dto.getName(), dto.getEmail(), dto.getPhoneNumber());
        contacts.add(contact);
        log.info("Created new contact: {}", contact);
        return contact;
    }

    public Optional<AddressBook> updateContact(int id, AddressBookDTO dto) {
        log.info("Updating contact with ID: {}", id);
        return getContactById(id).map(contact -> {
            contact.setName(dto.getName());
            contact.setEmail(dto.getEmail());
            contact.setPhoneNumber(dto.getPhoneNumber());
            log.info("Updated contact: {}", contact);
            return contact;
        });
    }

    public boolean deleteContact(int id) {
        log.info("Deleting contact with ID: {}", id);
        return contacts.removeIf(contact -> contact.getId() == id);
    }
}
