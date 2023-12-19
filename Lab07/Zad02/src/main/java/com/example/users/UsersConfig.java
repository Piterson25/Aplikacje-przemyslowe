package com.example.users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfig {
    @Bean
    public ArrayList<User> users() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        ArrayList<User> users = new ArrayList<>();
        try {
            users.add(new User(1, "Jillian", 26, User.UserType.ADMIN, df.parse("2022-02-17 11:01")));
            users.add(new User(2, "Mohandas", 22, User.UserType.GUEST, df.parse("2023-06-27 10:47")));
            users.add(new User(3, "Philly", 19, User.UserType.REGISTERED, df.parse("2022-06-21 10:12")));
            users.add(new User(4, "Kirsteni", 61, User.UserType.REGISTERED, df.parse("2022-08-22 16:13")));
            users.add(new User(5, "Cosetta", 34, User.UserType.ADMIN, df.parse("2023-03-11 12:35")));
            users.add(new User(6, "Hedvig", 71, User.UserType.GUEST, df.parse("2023-06-20 13:47")));
            users.add(new User(7, "Lorna", 28, User.UserType.REGISTERED, df.parse("2023-07-22 15:18")));
            users.add(new User(8, "Arty", 55, User.UserType.GUEST, df.parse("2022-06-14 14:25")));
        } catch (ParseException ignored) {

        }

        return users;
    }
}
