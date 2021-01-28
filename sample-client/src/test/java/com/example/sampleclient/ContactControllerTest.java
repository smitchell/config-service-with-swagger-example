package com.example.sampleclient;

import com.example.sampleclient.controllers.ContactController;
import com.example.sampleclient.models.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactControllerTest {

    @Autowired
    private ContactController contactController;

    @Test
    public void testAddContact() {
        final String uuid = UUID.randomUUID().toString();
        Contact contact = new Contact(uuid, "Steve", "Mitchell", "steve.mitchell@ahead.com");
        contact = contactController.addContact(contact);
        assertNotNull(contact, "Expected the added contact, but found none");
    }

    @Test
    public void testGetContactExists() {
        final String uuid = UUID.randomUUID().toString();
        Contact contact = new Contact(uuid, "Mary", "Vickers", "mary.vickers@ahead.com");
        contact = contactController.addContact(contact);
        assertNotNull(contact, "Expected the added contact, but found none");
        Optional<Contact> exists = contactController.getContact(uuid);
        assertFalse(exists.isEmpty(), "Exptected non-empty contact");

    }

    @Test
    public void testGetContactDoesntExists() {
        final String uuid = UUID.randomUUID().toString();
        Optional<Contact> exists = contactController.getContact(uuid);
        assertTrue(exists.isEmpty(), "Exptected empty contact");
    }

    @Test
    public void testListContacts() {
        final String uuid = UUID.randomUUID().toString();
        Contact contact = new Contact(uuid, "Mike", "Myers", "mike.myers@ahead.com");
        contact = contactController.addContact(contact);
        assertNotNull(contact, "Expected the added contact, but found none");
        List<Contact> contacts = contactController.getAllContact();
        assertNotNull(contacts, "Expected a contact list, but found none");
        assertFalse(contacts.isEmpty(), "Expected a non-empty contact list");
    }

}
