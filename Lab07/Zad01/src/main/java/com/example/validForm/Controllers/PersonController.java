package com.example.validForm.Controllers;

import com.example.validForm.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class PersonController {

    @GetMapping("/")
    public String homePage(Model model){
        return "home";
    }

    @GetMapping("/create")
    public String personForm(Model model){
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/create")
    public String processOrder(@Valid Person person, Errors errors){
        if(errors.hasErrors()){
            return "personForm";
        }
        log.info("Person created: " + person);
        return "redirect:/";
    }
}
