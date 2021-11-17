package com.example.geoApiTest.service;

import com.example.geoApiTest.exeption.RegistrationException;
import com.example.geoApiTest.model.Account;
import com.example.geoApiTest.model.DTO.UserDTO;
import com.example.geoApiTest.model.Role;
import com.example.geoApiTest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    @Autowired
    PasswordService passwordService;
    EmailService emailService;
    AccountRepository accountRepository;


    public RegistrationService(PasswordService passwordService,
                               EmailService emailService,
                               AccountRepository accountRepository) {
        this.passwordService = passwordService;
        this.emailService = emailService;
        this.accountRepository = accountRepository;
    }

    public String registration(UserDTO userDTO) throws RegistrationException {

        //checking email user is existing in database
        String email = userDTO.getEmail();
        if (emailService.emailExist(email)) {
            throw new RegistrationException("User with email = " + email + " already exist");
        }

        Account account = new Account();

        account.setEmail(email);
        //checking user password is valid
        String password = userDTO.getPassword();
        if (!passwordService.isValidPassword(password)) {
            throw new RegistrationException("Password is not valid");
        }

        //encode password
        account.setPassword(passwordService.encodePassword(userDTO.getPassword()));

        //add role and create record
        if (userDTO.getRole().equals("user")) {
            //role Mentor
            account.setRole(Role.USER);
            accountRepository.save(account);

        } else {
            return "You can only create user";
        }
        return "User created";
    }

}
