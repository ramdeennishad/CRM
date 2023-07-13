package com.crmproject.Services;

import com.crmproject.Entity.Lead;
import com.crmproject.Repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeadServiceImpl implements LeadService {
    LeadRepository leadRepository;
    LeadServiceImpl(LeadRepository leadRepository){

        this.leadRepository = leadRepository;
    }
    @Override
    public List<Lead> getAllLeads() {

        return leadRepository.findAll();
    }

    @Override
    public void saveLead(Lead lead) {
        leadRepository.save(lead);

    }

    @Override
    public Lead findLeadById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}
