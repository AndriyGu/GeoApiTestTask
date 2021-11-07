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

    @Operation(summary = "method add 1 admin, 3 moderators and 5 Users on you DB")
    @GetMapping("/add")
    //TODO delete after tests

    public String registerRoles() {

       try {
            int NUMBER_ADMINS = 1;
            int NUMBER_MODERATORS = 3;
            int NUMBER_USERS = 5;

            createAdmin(NUMBER_ADMINS);
            createModerators(NUMBER_MODERATORS);
            createUsers(NUMBER_USERS);

            return "tables added";
        } catch (Exception ex) {
            return "The DataBase might have a set of test values, and method  " +
                    "\"GET http://localhost:8080/system/add\" " +
                    "was already called   \n \n Error:   " + ex.getMessage();
        }
    }

    //Create admin
    private void createAdmin(int numberAdmins) {
        for (int i = 1; i <= numberAdmins; i++) {
            accountRepository.save(createOneAccount(i, Role.ADMIN));
        }
    }

    //Create moderators
    private void createModerators(int numberModerators) {
        for (int i = 1; i <= numberModerators; i++) {
            accountRepository.save(createOneAccount(i, Role.MODERATOR));
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
        n.setName(i+"__Name");

        return n;
    }
}
