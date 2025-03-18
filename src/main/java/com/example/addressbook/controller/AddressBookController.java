package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @PostMapping
    public ResponseEntity<AddressBook> createContact(@RequestBody AddressBookDTO dto) {
        AddressBook contact = new AddressBook(1, dto.getName(), dto.getEmail(), dto.getPhoneNumber());
        return ResponseEntity.ok(contact);
    }
}
