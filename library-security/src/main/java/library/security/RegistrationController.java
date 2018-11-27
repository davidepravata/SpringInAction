package library.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegisteredUsersRepository userRepo;

    public RegistrationController(RegisteredUsersRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegisteredUser form) {
        userRepo.save(form);
        return "redirect:/login";
    }
}
