package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable int id) {
        AddressBook contact = addressBookService.getContactById(id);
        return (contact != null) ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AddressBook> createContact(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.createContact(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        AddressBook updatedContact = addressBookService.updateContact(id, dto);
        return (updatedContact != null) ? ResponseEntity.ok(updatedContact) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        boolean deleted = addressBookService.deleteContact(id);
        return deleted ? ResponseEntity.ok("Contact deleted successfully") : ResponseEntity.notFound().build();
    }
}
