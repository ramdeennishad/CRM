package com.crmproject.Services;

import com.crmproject.Entity.Contact;
import com.crmproject.Repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    contactRepository contactRepository;
    ContactServiceImpl(contactRepository contactRepository){
        this.contactRepository= contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact findContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }



}
