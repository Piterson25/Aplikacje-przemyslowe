package com.example.users;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
public class User {
    private int id;

    @NotNull(message = "Name is required")
    @Size(min = 2, message = "Name should be at least two characters long")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be greater than zero")
    private int age;

    @NotNull(message = "User type is required")
    private UserType userType;

    @NotNull(message = "Registration date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date registrationDate;

    public User() {
    }

    public User(int id, String name, int age, UserType userType, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userType = userType;
        this.registrationDate = registrationDate;
    }

    public long getRegistrationDaysAgo() {
        return Duration.between(
                getRegistrationDate().toInstant(),
                Instant.now()
        ).toDays();
    }

    public enum UserType {
        GUEST, REGISTERED, ADMIN
    }
}
