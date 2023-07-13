package com.crmproject.Controller;

import com.crmproject.Dto.LeadDto;
import com.crmproject.Entity.Contact;
import com.crmproject.Entity.Lead;
import com.crmproject.Services.ContactService;
import com.crmproject.Services.LeadService;
import com.crmproject.mapper.LeadMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class LeadController {
    List<String> sources = Arrays.asList("Radio","NewsPaper","Social media","Trade Show","Website");
    LeadService leadService;
    ContactService contactService;

    LeadController(LeadService leadService, ContactService contactService) {
        this.leadService = leadService;
        this.contactService = contactService;
    }


    @GetMapping("/")
    String Home(Model model){
        model.addAttribute("leads", leadService.getAllLeads());
        return "view_lead";
    }
    @GetMapping("/create-lead")
    String createLead(Model model) {
        LeadDto leadDto = new LeadDto();
        Collections.sort(sources);
        model.addAttribute("sources", sources);
        model.addAttribute("lead", leadDto);
        return "create_lead";
    }
    @PostMapping("/create-lead")
    String saveLead(@ModelAttribute("lead") @Valid LeadDto lead, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()||lead.getMobile().length()<10){
            Collections.sort(sources);
            model.addAttribute("sources", sources);
            if(lead.getMobile().length()<10){
                bindingResult.rejectValue("mobile","Invalid mobile number","mobile  length should be 10 digit");
            }
            return "create_lead";
        }
        leadService.saveLead(LeadMapper.mapToLead(lead));
        return "redirect:/";
    }
    @GetMapping("/lead/{id}")
    String leadInfo(@PathVariable("id") Long id, Model model){
        Lead lead = leadService.findLeadById(id);
        model.addAttribute("lead",lead);
        return "lead_info";
    }

    @GetMapping("/lead/delete/{id}")
    String deleteLead(@PathVariable("id") Long id){
        leadService.deleteLead(id);
        return "redirect:/";
    }
    @GetMapping("/lead/convert/{id}")
    String convertLead(@PathVariable("id") Long id){
        Lead lead = leadService.findLeadById(id);
        contactService.saveContact(new Contact(null,lead.getFirstName(),lead.getLastName(),lead.getEmail(),lead.getMobile(),lead.getSource()));
        leadService.deleteLead(id);
        return "redirect:/contacts";
    }



}
