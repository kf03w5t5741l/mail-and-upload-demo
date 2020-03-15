package com.qienclass.mailanduploaddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.qienclass.mailanduploaddemo.domain.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/* Documentation for sending e-mails with Spring Boot:
 * https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/integration.html#mail
 *
 * Helpful guide:
 * https://mkyong.com/spring-boot/spring-boot-how-to-send-email-via-smtp/
 */
@Service
public class EmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendMail(Email email) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email.getRecipientAddress());
            helper.setFrom(email.getSenderAddress());
            helper.setSubject(email.getSubject());
            helper.setText(email.getMessage());
        } catch (MessagingException me) {
            me.printStackTrace();
        }

        this.mailSender.send(message);
    }
}
