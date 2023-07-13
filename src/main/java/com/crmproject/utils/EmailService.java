package com.crmproject.utils;

import com.crmproject.models.Email;

public interface EmailService {
    String sendEmail(Email email);
}
