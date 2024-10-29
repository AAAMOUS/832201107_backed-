package com.example.contacts.service.impl;

import com.example.contacts.mapper.ContactsMapper;
import com.example.contacts.pojo.Contacts;
import com.example.contacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsMapper contactMapper;

    /**
     * Retrieves a contact by its ID.
     *
     * @param id The ID of the contact to retrieve.
     * @return A Contacts object, or null if no contact is found.
     */
    public Contacts getContactsById(Long id) {
        return contactMapper.getContactsById(id);
    }

    /**
     * Retrieves a list of all contacts.
     *
     * @return A list of Contacts objects.
     */
    @Override
    public List<Contacts> getContacts() {
        return contactMapper.getContacts();
    }

    /**
     * Creates a new contact.
     *
     * @param contacts The Contacts object to be created.
     */
    public void createContacts(Contacts contacts) {
        contactMapper.createContacts(contacts);
    }

    /**
     * Updates an existing contact.
     *
     * @param contacts The Contacts object to be updated.
     */
    public void updateContacts(Contacts contacts) {
        contactMapper.updateContacts(contacts);
    }

    /**
     * Deletes a contact by its ID.
     *
     * @param id The ID of the contact to delete.
     */
    public void deleteContacts(Long id) {
        contactMapper.deleteContacts(id);
    }
}

