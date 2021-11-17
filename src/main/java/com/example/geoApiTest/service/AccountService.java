package com.example.geoApiTest.service;

import com.example.geoApiTest.model.Account;
import com.example.geoApiTest.repository.AccountRepository;
import com.example.geoApiTest.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}


