package com.codecool.BookShop.config;

import com.codecool.BookShop.model.Role;
import com.codecool.BookShop.model.User;
import com.codecool.BookShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitClass {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/init")
    public String init() {
        Role roleAdmin = new Role("admin");
        Role roleUser = new Role("user");

        User user1 = new User("daro", "daro123");
        user1.addRole(roleAdmin);
        User user2 = new User("roman", "roman123");
        user2.addRole(roleUser);

        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("dupa");
        return "Basic resources initialized!";
    }
}
