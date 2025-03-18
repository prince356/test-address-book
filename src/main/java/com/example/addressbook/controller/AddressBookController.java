package com.example.addressbook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("Fetching all contacts...");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("Fetching contact with ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> createContact(@RequestBody String contact) {
        return ResponseEntity.ok("Creating contact: " + contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id, @RequestBody String contact) {
        return ResponseEntity.ok("Updating contact with ID " + id + " to: " + contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("Deleting contact with ID: " + id);
    }
}
