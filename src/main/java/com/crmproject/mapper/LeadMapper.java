package com.crmproject.mapper;

import com.crmproject.Dto.LeadDto;
import com.crmproject.Entity.Lead;

public class LeadMapper {
    public static Lead mapToLead(LeadDto leadDto){
        return Lead.builder()
                .id(leadDto.getId())
                .firstName(leadDto.getFirstName())
                .lastName(leadDto.getLastName())
                .email(leadDto.getEmail())
                .mobile(leadDto.getMobile())
                .source(leadDto.getSource())
                .build();
    }
    public static LeadDto mapToDto(Lead lead){
        return LeadDto.builder()
                .id(lead.getId())
                .firstName(lead.getFirstName())
                .lastName(lead.getLastName())
                .email(lead.getEmail())
                .mobile(lead.getMobile())
                .source(lead.getSource())
                .build();
    }




}
