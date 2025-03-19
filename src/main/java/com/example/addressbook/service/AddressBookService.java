package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.exception.ResourceNotFoundException;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookService {

    private final AddressBookRepository repository;

    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    public List<AddressBook> getAllContacts() {
        log.info("Fetching all contacts from database...");
        return repository.findAll();
    }

    public AddressBook getContactById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact with ID " + id + " not found"));
    }

    public AddressBook createContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(0, dto.getName(), dto.getEmail(), dto.getPhoneNumber());
        log.info("Saving new contact: {}", contact);
        return repository.save(contact);
    }

    public AddressBook updateContact(int id, AddressBookDTO dto) {
        AddressBook contact = getContactById(id);
        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setPhoneNumber(dto.getPhoneNumber());
        log.info("Updating contact: {}", contact);
        return repository.save(contact);
    }

    public void deleteContact(int id) {
        AddressBook contact = getContactById(id);
        repository.delete(contact);
        log.info("Deleted contact with ID: {}", id);
    }
}
