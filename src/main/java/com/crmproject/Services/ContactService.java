package com.crmproject.Services;

import com.crmproject.Entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    void saveContact(Contact contact);
    Contact findContactById(Long id);
    void deleteContact(Long id);


}
