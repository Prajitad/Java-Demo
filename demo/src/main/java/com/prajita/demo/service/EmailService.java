package com.prajita.demo.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor

public class EmailService {
    private final JavaMailSender mailSender;
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("pramiktamang@gmail.com");
        message.setSubject("Test");
        message.setText("HI");
        mailSender.send(message);
    }


    public void sendMailWithAttachment() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.addAttachment("Screenshot (103).png",
                new ClassPathResource("Screenshot (103).png"));
        helper.setSubject("Test");
        helper.setText("Hello World");
        helper.setTo("pramiktamang@gmail.com");
        mailSender.send(message);
//    }
//
//    public void sendHtmlMail() throws MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(
//                message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                StandardCharsets.UTF_8.name());
//        String html = """
//            <html>
//                <body>
//                    <h1>Test</h1>
//                    <h2>Test2</h2>
//                    <h3>Test3</h3>
//               </body>
//            </html>
//            """;
//        helper.setSubject("Test");
//        helper.setText(html,true);
//        helper.setTo("pramiktamang@gmail.com");
//        mailSender.send(message);
//    }

    }
}
