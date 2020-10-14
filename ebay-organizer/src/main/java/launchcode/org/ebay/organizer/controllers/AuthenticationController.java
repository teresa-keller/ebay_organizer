package launchcode.org.ebay.organizer.controllers;

import javax.validation.Valid;
import launchcode.org.ebay.organizer.models.User;
import launchcode.org.ebay.organizer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller

public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("login")
    public String displayLoginPage() {
        return "user/login";
    }

    @GetMapping("/user/register")
    public String displayRegistrationForm(WebRequest request, Model model) {

        userRepository.save(new User());
        model.addAttribute("user", userRepository.findAll());

        return "user/register";
    }

    @PostMapping("register")
    public String processRegistrationForm(@ModelAttribute("user") @Valid User newUser, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "register");
            return "register";
        }
        userRepository.save(newUser);

        return "/index";
    }
}
