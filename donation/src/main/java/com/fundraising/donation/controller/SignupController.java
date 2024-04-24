package com.fundraising.donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundraising.donation.model.Signup;
import com.fundraising.donation.service.SignupService;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public String saveUser(@RequestBody Signup signup) {
        return signupService.saveUser(signup);
    }

    @GetMapping("/signin")
    public String validate(@RequestParam String email,@RequestParam String password) {
        return signupService.validate(email, password);
    }

}
