package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private final List<AddressBook> contacts = new ArrayList<>();
    private int idCounter = 1;

    public List<AddressBook> getAllContacts() {
        return contacts;
    }

    public AddressBook getContactById(int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public AddressBook createContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(idCounter++, dto.getName(), dto.getEmail(), dto.getPhoneNumber());
        contacts.add(contact);
        return contact;
    }

    public AddressBook updateContact(int id, AddressBookDTO dto) {
        for (AddressBook contact : contacts) {
            if (contact.getId() == id) {
                contact.setName(dto.getName());
                contact.setEmail(dto.getEmail());
                contact.setPhoneNumber(dto.getPhoneNumber());
                return contact;
            }
        }
        return null;
    }

    public boolean deleteContact(int id) {
        return contacts.removeIf(contact -> contact.getId() == id);
    }
}
