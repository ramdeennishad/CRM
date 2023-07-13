package com.crmproject.Controller;

import com.crmproject.Entity.Contact;
import com.crmproject.Entity.Lead;
import com.crmproject.Services.ContactService;
import com.crmproject.Services.LeadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContactController {
    final ContactService contactService;
    final LeadService leadService;

    public ContactController(ContactService contactService, LeadService leadService) {
        this.contactService = contactService;
        this.leadService = leadService;
    }

    @GetMapping("/contacts")
    String showContact(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "/view_contacts";
    }

    @GetMapping("/contact/{id}")
    String contactInfo(@PathVariable("id") Long id, Model model) {
        Contact contact = contactService.findContactById(id);
        model.addAttribute("contact", contact);
        return "contact_info";
    }

    @GetMapping("/contact/delete/{id}")
    String deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

    @GetMapping("/contact/convert/{id}")
    String convertContact(@PathVariable("id") Long id) {
        Contact lead = contactService.findContactById(id);
        leadService.saveLead(new Lead(null, lead.getFirstName(), lead.getLastName(), lead.getEmail(), lead.getMobile(), lead.getSource()));
        contactService.deleteContact(id);
        return "redirect:/";

    }
}