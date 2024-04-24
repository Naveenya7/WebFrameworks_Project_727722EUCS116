package com.fundraising.donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundraising.donation.model.Signup;
import com.fundraising.donation.repository.SignupRepository;

@Service
public class SignupService {
    
    @Autowired
    private SignupRepository signupRepository;

    public String saveUser(Signup signup) {
        signupRepository.save(signup);
        return "User saved";
    }

    public String validate(String email,String password){
        Signup signup = signupRepository.findByEmail(email);
        if(signup == null){
            return "User not found";
        }
        if(signup.getPassword().equals(password)){
            return "Login successful";
        }
        return "Invalid password";
    }
}
