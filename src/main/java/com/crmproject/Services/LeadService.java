package com.crmproject.Services;

import com.crmproject.Entity.Lead;

import java.util.List;

public interface LeadService {
    List<Lead> getAllLeads();
    void saveLead(Lead lead);
    Lead findLeadById(Long id);
    void deleteLead(Long id);
}
