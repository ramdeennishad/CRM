package com.crmproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillingController {
    @GetMapping("/generatebill")
    String billingForm(){
        return "generate_bill_form";
    }
}
