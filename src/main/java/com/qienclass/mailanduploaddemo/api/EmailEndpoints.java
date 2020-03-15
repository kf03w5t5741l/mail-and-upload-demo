package com.qienclass.mailanduploaddemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qienclass.mailanduploaddemo.domain.Email;
import com.qienclass.mailanduploaddemo.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailEndpoints {
    @Autowired
    private EmailService emailService;


    @PostMapping
    public void sendEmail(@RequestBody Email email) {
        this.emailService.sendMail(email);
    }
}
