package com.fundraising.donation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundraising.donation.model.Donation;
import com.fundraising.donation.service.DonationService;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController

@RequestMapping("/donation")
public class DonationController {
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }
    
    @Autowired
    private DonationService donationService;
    @PostMapping("/mapbyid")
    public String saveDonation(@RequestBody Donation donation) {
        return donationService.saveDonation(donation);
    }
    @GetMapping("/get")
    public Donation getDonationDetails(@RequestParam String email) {
        return donationService.getDonationDetails(email);

    }
    @GetMapping("/getAll")
    public List<Donation> getDonationDetails() {
        return donationService.getAllDonationDetails();
    }
    @PostMapping("/donation/mapbycity")
    public String mapDonationByCity(@RequestBody Donation donation){
        
        return donationService.mapDonationByCity(donation);
    }
    @DeleteMapping("/delete")
   public String deleteDonation(@RequestParam String email){
       if(donationService.getDonationDetails(email)!=null)
       donationService.deleteDonation(email);
       else
       return "No data found";
       return "Donation deleted";
   }
   @PutMapping("/update")
   public ResponseEntity<String> updateDonation(@RequestBody Donation newdonation){
       Donation olddonation=donationService.getDonationDetails(newdonation.getEmail());
       if(olddonation!=null){
           //olddonation.setId(newdonation.getId());
           olddonation.setUsername(newdonation.getUsername());
           olddonation.setAmount(newdonation.getAmount());
           donationService.saveDonation(olddonation);
           
       }
       else
       return new ResponseEntity<>("data not found", HttpStatus.CREATED);
       return new ResponseEntity<>("Donation updated", HttpStatus.ACCEPTED);
       
   }
    
}
