package launchcode.org.ebay.organizer.controllers;

import java.util.Optional;
import launchcode.org.ebay.organizer.data.ListingRepository;
import launchcode.org.ebay.organizer.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("listings")
public class ListingController {

    @Autowired
    ListingRepository listingRepository;

    @GetMapping
    public String displayAllListings(Model model) {

        model.addAttribute("title", "All Listings");
        model.addAttribute("listings", listingRepository.findAll());
    return "listings/index";
    }

    @GetMapping("create")
    public String displayCreateListingForm(Model model) {
       model.addAttribute("title", "Create Listing");
       model.addAttribute(new Listing());
        return "listings/create";
    }

    @PostMapping("create")
    public String processCreateListingForm(@ModelAttribute @Validated Listing newListing, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "create");
            return "create";
        }
        listingRepository.save(newListing);

        return "redirect:";
    }

    @GetMapping("view/{listingId}")
    public String displayViewListing(Model model, @PathVariable Integer listingId) {
        model.addAttribute("listing", listingRepository.findAll());

        Optional optionalListing = listingRepository.findById(listingId);
        if (optionalListing.isPresent()) {
            Listing listing = (Listing) optionalListing.get();
            model.addAttribute("title", ((Listing) optionalListing.get()).getId());
            model.addAttribute("listing", listing);
            return "listings/view";
        } else {
            return "redirect:../";
        }
    }
}
