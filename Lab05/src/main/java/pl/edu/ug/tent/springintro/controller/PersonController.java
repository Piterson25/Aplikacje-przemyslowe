package pl.edu.ug.tent.springintro.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springintro.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class PersonController {
    private static List<Person> users = new ArrayList<>();

    @GetMapping
    public List<Person> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public Person getUserById(@PathVariable String id) {
        Optional<Person> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
    }

    @PostMapping
    public Person addUser(@RequestBody Person newUser) {
        newUser.setId(generateUserId());
        users.add(newUser);
        return newUser;
    }

    @PutMapping("/{id}")
    public Person updateUser(@PathVariable String id, @RequestBody Person updatedUser) {
        Optional<Person> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (user.isPresent()) {
            Person existingUser = user.get();
            existingUser.setFirst_name(updatedUser.getFirst_name());
            existingUser.setLast_name(updatedUser.getLast_name());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setCompany_name(updatedUser.getCompany_name());
            return existingUser;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        Optional<Person> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (user.isPresent()) {
            users.remove(user.get());
            return "Deleted user with ID: " + id;
        } else {
            return "User with given ID doesnt exist";
        }
    }

    private String generateUserId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}