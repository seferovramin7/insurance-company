package azericardramin.insurancecompany.service;

import azericardramin.insurancecompany.email.EmailService;
import azericardramin.insurancecompany.model.User;
import azericardramin.insurancecompany.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistryService {

    private UserRepository userRepository;
    private EmailService emailService;

    public RegistryService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User save(User user, String role){
        if (role == "superadmin"){
            userRepository.save(user);
            emailService.sendPlainText()
        }
    }

}
