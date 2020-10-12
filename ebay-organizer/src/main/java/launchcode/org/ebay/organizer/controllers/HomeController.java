package launchcode.org.ebay.organizer.controllers;

import java.io.IOException;
import launchcode.org.ebay.organizer.services.EbaySearchService;
import launchcode.org.ebay.organizer.services.Query;
import launchcode.org.ebay.organizer.services.QuerySearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("services")
public class HomeController {

    @GetMapping
    public String searchIndex(Model model) throws IOException {
        EbaySearchService ebaySearchService = new EbaySearchService();
        Query query = ebaySearchService.getQuery();

        model.addAttribute("query", query);

        return "index";
    }

    @GetMapping("/query")
    public String otherSearchIndex(Model model, @RequestParam String searchTerm) throws IOException {
        EbaySearchService ebaySearchService = new EbaySearchService();
        QuerySearch querySearches = ebaySearchService.searchQuery(searchTerm);

        model.addAttribute("querySearches", querySearches);

        return "query";
    }
}
