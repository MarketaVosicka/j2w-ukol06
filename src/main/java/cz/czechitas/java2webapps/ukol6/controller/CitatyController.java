package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.CitatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
public class CitatyController {

    private final CitatyService citatyService;

    @Autowired
    public CitatyController(CitatyService citatyService) {
        this.citatyService = citatyService;
    }

    @GetMapping("/")
    public ModelAndView nahodnyCitat() {
        return new ModelAndView("citat")
                .addObject("citat", citatyService.nahodnyCitat());
    }

    @GetMapping("/{cislo}")
    public ModelAndView easter(@PathVariable int cislo) {
        return new ModelAndView("citat")
                .addObject("citat", citatyService.konkretniCitat(cislo));
    }
}
