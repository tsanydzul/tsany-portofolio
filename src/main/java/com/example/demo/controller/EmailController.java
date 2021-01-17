package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Mail;
import com.example.demo.model.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.impl.EmailServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {

    private final UserDao userDao;
    private final EmailService emailService;

    public EmailController(UserDao userDao, EmailServiceImpl emailServiceImpl, EmailService emailService) {
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/sendEmail")
    public String sendEmail(){
        Mail mail = new Mail();
        mail.setMailFrom("tsany.dzul@gmail.com");
        mail.setMailTo("tsany.bisnis@gmail.com");
        mail.setMailSubject("Muhammad Tsany Dzul - Resume");
        mail.setMailContent("Hi Sir/Madam, here my resume attached");
        
//        mail.setAttachments();

        emailService.sendEmail(mail);
        return "kopet";
    }

    @PostMapping("/employees")
    User newEmployee(@RequestBody User user) {
        return userDao.save(user);
    }



//    private void sendmail() throws AddressException, MessagingException, IOException {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("tutorialspoint@gmail.com", "<your password>");
//            }
//        });
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));
//
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tutorialspoint@gmail.com"));
//        msg.setSubject("Tutorials point email");
//        msg.setContent("Tutorials point email", "text/html");
//        msg.setSentDate(new Date());
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Tutorials point email", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();
//
//        attachPart.attachFile("/var/tmp/image19.png");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
//        Transport.send(msg);
//    }
}
