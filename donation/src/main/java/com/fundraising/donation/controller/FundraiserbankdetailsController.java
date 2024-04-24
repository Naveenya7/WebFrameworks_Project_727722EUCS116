package com.fundraising.donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundraising.donation.model.Fundraiserbankdetails;
import com.fundraising.donation.service.FundraiserbankdetailsService;

@RestController
@RequestMapping("/fundraiserbankdetails")
public class FundraiserbankdetailsController {
    @Autowired
    private FundraiserbankdetailsService fundraiserbankdetailsService;
    @PostMapping("/post")
    public String saveFundraiserbank(@RequestBody Fundraiserbankdetails fundraiserbankdetails) {
        return fundraiserbankdetailsService.saveFundraiserbank(fundraiserbankdetails);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updatefundraiserbank(@RequestBody Fundraiserbankdetails newFundraiserbankdetails){
        Fundraiserbankdetails oldFundraiserbankdetails=fundraiserbankdetailsService.getFundraiserbankDetails(newFundraiserbankdetails.getId());
        if(oldFundraiserbankdetails!=null){
            
            oldFundraiserbankdetails.setName(newFundraiserbankdetails.getName());
            oldFundraiserbankdetails.setAcno(newFundraiserbankdetails.getAcno());
            fundraiserbankdetailsService.saveFundraiserbank(oldFundraiserbankdetails);
            
        }
        else
        return new ResponseEntity<>("data not found", HttpStatus.CREATED);
        return new ResponseEntity<>("Bank details updated", HttpStatus.ACCEPTED);
        
    }
    
}
