package launchcode.org.ebay.organizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("information")
public class InformationController {

    @GetMapping
    public String displayAllInformation() {
        return "information/index";
    }
}