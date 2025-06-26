package com.zidio.Opplinkr.Controller;

import com.zidio.Opplinkr.Service.EmailService;
import com.zidio.Opplinkr.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> send(EmailRequest request) {
        return ResponseEntity.ok(emailService.sendMail(request));
    }

}
