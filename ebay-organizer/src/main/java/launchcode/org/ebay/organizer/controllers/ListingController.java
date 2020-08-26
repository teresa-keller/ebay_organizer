package launchcode.org.ebay.organizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("listings")
public class ListingController {

    @GetMapping
    public String displayAllListings() {
        return "listings/index";
    }

    @GetMapping("create")
    public String displayCreateListingForm() {
        return "listings/create";
    }

    @PostMapping("create")
    public String processCreateListingForm() {
        return "listings/index";
    }
}
