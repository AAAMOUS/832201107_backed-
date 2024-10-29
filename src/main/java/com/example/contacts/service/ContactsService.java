package com.example.contacts.service;

import com.example.contacts.pojo.Contacts;

import java.util.List;

public interface ContactsService {
    List<Contacts> getContacts();
    Contacts getContactsById(Long id);
    void createContacts(Contacts contacts);

    void updateContacts(Contacts contacts);

    void deleteContacts(Long id);
}
