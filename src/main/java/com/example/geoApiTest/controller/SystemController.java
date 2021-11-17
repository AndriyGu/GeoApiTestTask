package com.example.geoApiTest.controller;

import com.example.geoApiTest.model.Account;
import com.example.geoApiTest.model.Role;
import com.example.geoApiTest.repository.AccountRepository;
import com.example.geoApiTest.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private final AccountRepository accountRepository;
    private final PasswordService passwordService;

    public SystemController(
            AccountRepository accountRepository,
            PasswordService passwordService) {
        this.accountRepository = accountRepository;
        this.passwordService = passwordService;
    }

    @Operation(summary = "method add 1 Users on you DB")
    @GetMapping("/add")
    //TODO delete after tests

    public String registerRoles() {

        try {
            int NUMBER_USERS = 1;
            createUsers(NUMBER_USERS);

            return "tables added";
        } catch (Exception ex) {
            return "The DataBase might have a set of test values, and method  " +
                    "\"GET http://localhost:8080/system/add\" " +
                    "was already called   \n \n Error:   " + ex.getMessage();
        }
    }


    //Create users
    private void createUsers(int numberUsers) {
        for (int i = 1; i <= numberUsers; i++) {
            accountRepository.save(createOneAccount(i, Role.USER));
        }
    }

    private Account createOneAccount(int i, Role role) {

        Account n = new Account();
        n.setEmail(i + "_" + role.name() + "@email.com");
        n.setPassword(passwordService.encodePassword("password"));
        n.setRole(role);
        n.setName(i + "__Name");

        return n;
    }
}
