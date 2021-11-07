package com.example.geoApiTest.service;

import com.example.geoApiTest.exeption.RegistrationException;
import com.example.geoApiTest.model.Account;
import com.example.geoApiTest.repository.AccountRepository;
import com.example.geoApiTest.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    JwtProvider jwtProvider;
    AccountRepository accountRepository;

    public AccountService(ApplicationEventPublisher applicationEventPublisher, JwtProvider jwtProvider, AccountRepository accountRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.jwtProvider = jwtProvider;
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }


    public Account getAccountByHeader(String header) throws Exception {
        String token;
        if (header.startsWith("Bearer ")) {
            token = header.substring(7);
        } else {
            token = header;
        }
        if (!jwtProvider.validateToken(token)) {
            throw new Exception("Your token is expired");
        }
        String email = jwtProvider.getLoginFromToken(token);
        return accountRepository.findByEmail(email);
    }

    public Account getUserById(String id) {
        int userId = Integer.parseInt(id);
        return accountRepository.findOneById(userId);
    }
}


