package com.example.sampleclient.controllers;

import com.example.sampleclient.models.Contact;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Contact by Id", notes = "Given an ID, returns a contact", response = Contact.class)
    public Optional<Contact> getContact(@PathVariable final String id) {
        final Contact contact = contacts.get(id);
        if (contact == null) {
            return Optional.empty();
        }
        return Optional.of(contact);
    }

    @GetMapping("/")
    @ApiOperation(value = "Lists all contacts", response = List.class)
    public List<Contact> getAllContact() {
        return new ArrayList<>(contacts.values());
    }

    @PostMapping("/")
    @ApiOperation(value = "Adds a new Contact", notes = "Id must be null", response = Contact.class)
    public Contact addContact(@RequestBody final Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
