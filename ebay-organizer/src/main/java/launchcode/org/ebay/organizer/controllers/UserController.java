package launchcode.org.ebay.organizer.controllers;

import launchcode.org.ebay.organizer.data.UserRepository;
import launchcode.org.ebay.organizer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String displayLoginPage() {
        return "user/login";
    }


    @GetMapping("register")
    public String displayRegistrationForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("title", "Register");
        model.addAttribute("user", userRepository.findAll());

        return "user/register";
    }

    @PostMapping("register")
    public String processRegistrationForm(@ModelAttribute User newUser, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "register");
            return "register";
        }
        userRepository.save(newUser);

        return "/index";
    }

}
