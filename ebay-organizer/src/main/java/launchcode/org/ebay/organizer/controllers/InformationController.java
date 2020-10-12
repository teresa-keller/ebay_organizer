package launchcode.org.ebay.organizer.controllers;

import java.util.Optional;
import launchcode.org.ebay.organizer.data.InformationRepository;
import launchcode.org.ebay.organizer.models.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("information")
public class InformationController {

    @Autowired
    InformationRepository informationRepository;


    @GetMapping("/")
    public String displayAllInformation(Model model) {
        informationRepository.save(new Information());
        model.addAttribute("title", "All Information");
        model.addAttribute("information", informationRepository.findAll());
        return "information/index";
    }

    @PostMapping
    public String processAllInformation(Model model, Information newInformation) {
        model.addAttribute("title", "All Information");
        informationRepository.save(newInformation);
        model.addAttribute("information", informationRepository.findAll());
        return "information/index";
    }

    @GetMapping("add")
    public String addInformation(Model model) {
        model.addAttribute("title", "Add Information");
        model.addAttribute(new Information());
        return "information/add";
    }

    @PostMapping("add")
    public String processInformation(@ModelAttribute @Validated Information newInformation, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "add");
            return "add";
        }
        informationRepository.save(newInformation);

        model.addAttribute("information", informationRepository.findAll());

        return "redirect:../";
    }
    @GetMapping("view/{informationId}")
    public String displayViewInformation(Model model, @PathVariable Integer informationId) {
        model.addAttribute("information", informationRepository.findAll());

        Optional optionalInformation = informationRepository.findById(informationId);
        if (optionalInformation.isPresent()) {
            Information information = (Information) optionalInformation.get();
            model.addAttribute("title", ((Information) optionalInformation.get()).getName());
            model.addAttribute("information", information);
            model.addAttribute("name", information.getName());
            return "information/index/view";
        } else {
            return "redirect:../";
        }
    }

}
