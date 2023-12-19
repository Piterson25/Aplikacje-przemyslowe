package com.example.users.Controllers;

import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

@Slf4j
@Controller
public class UsersController {
    @Autowired
    public ArrayList<User> users;

    @GetMapping("/")
    public String home(Model model) throws ParseException {
        String startDateString = "20/05/2007 07:32";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date startDate = df.parse(startDateString);
        User user = new User(2, "Artur", 34, User.UserType.ADMIN, startDate);
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/form")
    public String processOrder(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "userForm";
        }

        if (users.isEmpty()) {
            user.setId(1);
        } else {
            user.setId(users.get(users.size() - 1).getId() + 1);
        }

        users.add(user);
        log.info("User created: " + user);
        return "redirect:/list";
    }
}
