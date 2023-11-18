package com.tje.users;

import com.tje.users.User.UserType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class UsersController {

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
    public String list(Model model) throws ParseException {
        ArrayList<User> users = new ArrayList<User>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        users.add(new User(1, "Alice", 30, UserType.ADMIN, df.parse("2023-01-05 09:15")));
        users.add(new User(2, "Bob", 25, UserType.GUEST, df.parse("2023-02-15 11:30")));
        users.add(new User(3, "Charlie", 22, UserType.REGISTERED, df.parse("2023-03-25 14:45")));
        users.add(new User(4, "David", 40, UserType.REGISTERED, df.parse("2023-04-10 16:20")));
        users.add(new User(5, "Eve", 28, UserType.ADMIN, df.parse("2023-05-20 10:00")));
        users.add(new User(6, "Frank", 35, UserType.GUEST, df.parse("2023-06-30 12:30")));
        users.add(new User(7, "Grace", 27, UserType.REGISTERED, df.parse("2023-07-15 15:45")));

        model.addAttribute("users", users);
        return "list";
    }

}
