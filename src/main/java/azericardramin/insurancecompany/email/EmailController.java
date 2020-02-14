package azericardramin.insurancecompany.email;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class EmailController {
    private EmailService EmailService;

    public EmailController(EmailService EmailService) {
        this.EmailService = EmailService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Email mail) {
        EmailService.sendPlainText(mail.to, mail.subject,mail.text);
    }
}
