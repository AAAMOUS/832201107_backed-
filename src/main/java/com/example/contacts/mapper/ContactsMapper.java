package com.example.contacts.mapper;

import com.example.contacts.pojo.Contacts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactsMapper {
    List<Contacts> getContacts();

    Contacts getContactsById(Long id);

    void createContacts(Contacts contacts);

    void updateContacts(Contacts contacts);

    void deleteContacts(Long id);
}
