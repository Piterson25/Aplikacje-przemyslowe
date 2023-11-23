package com.example.validForm;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Person {

    @NotNull(message = "Name is required")
    @Size(min = 2, message = "Name should be start at least two characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be at least zero")
    private int age;

    @NotNull(message = "Zip code is required")
    @Pattern(regexp = "\\d\\d-\\d\\d\\d", message = "Unsupported zip code format")
    private String zip_code;

    @NotNull(message = "Earnings is required")
    @Min(value = 2000, message = "Earnings must be at least 2000")
    @Max(value = 3000, message = "Earnings must be at most 3000")
    private int earnings;

    private boolean accept;
}
