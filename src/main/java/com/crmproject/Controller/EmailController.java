package com.crmproject.Controller;

import com.crmproject.models.Email;
import com.crmproject.utils.EmailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email/compose-email")
    String composeEmail(Model model, @RequestParam("email") String recipientEmail){
        model.addAttribute("email",new Email(recipientEmail,null,null));
        return "compose_email";
    }

    @PostMapping("/email/send")
    String sendEmail(@Valid @ModelAttribute("email") Email email, BindingResult bindingResult, Model model){
        model.addAttribute("email",email);
        if(bindingResult.hasErrors()){
            return "compose_email";
        }
        String res=emailService.sendEmail(email);
        System.out.println(res);
        return "redirect:/contacts";
    }
}
