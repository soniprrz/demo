package com.geektext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Geektext.repository.CreditCardRepository;
import Geektext.repository.UserRepository;
import profilemanagement.CreditCard;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/{username}")
    public void createCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        org.springframework.boot.autoconfigure.security.SecurityProperties.User user = (org.springframework.boot.autoconfigure.security.SecurityProperties.User) userRepository.findByUsername(username);
        if (user != null) {
            creditCard.setUser(user);
            creditCardRepository.save(creditCard);
        }
    }
}

