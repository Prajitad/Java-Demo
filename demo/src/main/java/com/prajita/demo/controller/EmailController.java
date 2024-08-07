package com.prajita.demo.controller;

import com.prajita.demo.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping("/simple")
    public ResponseEntity<String> simple() {
        emailService.sendSimpleMail();
        return ResponseEntity.ok("Simple email sent");

    }

    @GetMapping("/att")
    public ResponseEntity<String> attachment() throws MessagingException {
        emailService.sendMailWithAttachment();
        return ResponseEntity.ok("Attachment email sent");
    }

}