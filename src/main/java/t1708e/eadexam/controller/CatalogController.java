package t1708e.eadexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708e.eadexam.entity.Book;
import t1708e.eadexam.entity.Catalog;
import t1708e.eadexam.service.CatalogService;

import java.util.List;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Catalog> catalogs = catalogService.catalogs();
        model.addAttribute("catalogs", catalogs);
        return "catalog/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("catalog", new Catalog());
        return "catalog/form";
    }
}
