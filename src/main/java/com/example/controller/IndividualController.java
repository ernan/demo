package com.example.controller;


import com.example.domain.Individual;
import com.example.service.IndividualService;
import com.example.web.api.IndividualValdator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndividualController {
    @Autowired
    private IndividualService individualService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @InitBinder("individual")
    protected void initIndividualValdator(WebDataBinder binder) {
        binder.addValidators(new IndividualValdator());
    }

    @RequestMapping(value = "/individual", method = RequestMethod.GET)
    public String individual(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null) {
            Individual individual = individualService.findOne(Long.valueOf(id));
            model.addAttribute("individual", individual);
        } else {
            Individual individual = individualService.createEmpty();
            model.addAttribute("individual", individual);
        }
        return "individual";
    }

    @RequestMapping(value = "/individual", method = RequestMethod.POST)
    public String doSave(Individual individual, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (individual.getId() == null) {
                individualService.create(individual);
            } else {
                if (individualService.findOne(individual.getId()) != null) {
                    individualService.update(individual);
                }
            }
        }
        return "individual";
    }

    @RequestMapping("/list")
    public String individual(Model model) {
        model.addAttribute("individuals", individualService.findAll());
        return "list";
    }
}
