package com.example.contacts.controller;

import com.example.contacts.pojo.Contacts;
import com.example.contacts.pojo.Result;
import com.example.contacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ContactsController class handles HTTP requests related to contacts.
 * It is annotated with @RestController to indicate that it is a RESTful controller,
 * and @RequestMapping("/contacts") to define the base path for the requests.
 */
@RestController
@RequestMapping("/contacts")
public class ContactsController {

    /**
     * Autowires an instance of ContactsService to handle business logic related to contacts.
     */
    @Autowired
    private ContactsService contactsService;

    /**
     * Handles GET requests to search for a list of contacts.
     *
     * @return A Result object containing the list of contacts.
     */
    @GetMapping("/search")
    public Result getContacts() {
        List<Contacts> contacts = contactsService.getContacts();
        return Result.success(contacts);
    }

    /**
     * Handles POST requests to create a new contact.
     *
     * @param contacts The contact object to be created, with properties bound from the form.
     * @return An HTTP response entity indicating the result of the creation.
     */
    @PostMapping("/add")
    public ResponseEntity<String> createContacts(@ModelAttribute Contacts contacts) {
        try {
            contactsService.createContacts(contacts);
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create contact");
        }
    }

    /**
     * Handles PUT requests to update an existing contact.
     *
     * @param contacts The contact object to be updated, with properties bound from the form.
     * @return A Result object indicating the result of the update.
     */
    @PutMapping("/edit")
    public Result updateContacts(@ModelAttribute Contacts contacts) {
        try {
            contactsService.updateContacts(contacts);
            return Result.success("Contact updated successfully");
        } catch (Exception e) {
            return Result.error("Failed to update contact");
        }
    }

    /**
     * Handles DELETE requests to delete a specific contact.
     *
     * @param id The ID of the contact to be deleted.
     * @return A Result object indicating the result of the deletion.
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteContacts(@PathVariable Long id) {
        contactsService.deleteContacts(id);
        return Result.success();
    }

    /**
     * Handles GET requests to find a specific contact by ID.
     *
     * @param id The ID of the contact to be found.
     * @return A Result object containing the contact details or an error message.
     */
    @GetMapping("/find/{id}")
    public Result getContactsById(@PathVariable Long id) {
        Contacts contacts = contactsService.getContactsById(id);
        if (contacts != null) {
            return Result.success(contacts);
        } else {
            return Result.error("Contacts not found with id: " + id);
        }
    }
}
