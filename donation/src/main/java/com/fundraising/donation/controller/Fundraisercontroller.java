package com.fundraising.donation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fundraising.donation.model.Fundraiser;
import com.fundraising.donation.service.FundraiserService;

import java.util.List;
import org.springframework.data.domain.Page;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/fundraiser")
public class Fundraisercontroller {
   @Autowired
   private FundraiserService fundraiserService;

   @PostMapping("/post")
   public String saveFundraiser(@RequestBody Fundraiser fundraiser) {
       return fundraiserService.saveFundraiser(fundraiser);
   }

   @GetMapping("/get")
   public Fundraiser getFundraiserDetails(@RequestParam String name) {
       return fundraiserService.getFundraiserDetails(name);
   }

   @GetMapping("/getAll")
   public List<Fundraiser> getFundraiserDetails() {
       return fundraiserService.getAllFundraiserDetails();
   }

   @DeleteMapping("/delete")
   public String deleteStudent(@RequestParam String name){
       if(fundraiserService.getFundraiserDetails(name)!=null)
       fundraiserService.deleteFundraiser(name);
       else
       return "No data found";
       return "Fundraiser deleted";
   }
   

   @PutMapping("/update")
   public ResponseEntity<String> updateFundraiser(@RequestBody Fundraiser newFundraiser){
       Fundraiser oldFundraiser=fundraiserService.getFundraiserDetails(newFundraiser.getName());
       if(oldFundraiser!=null){
           oldFundraiser.setEmail(newFundraiser.getEmail());
           oldFundraiser.setDescription(newFundraiser.getDescription());
           oldFundraiser.setGoalamount(newFundraiser.getGoalamount());
           oldFundraiser.setEnddate(newFundraiser.getEnddate());
           fundraiserService.saveFundraiser(oldFundraiser);
       }
       else
       return new ResponseEntity<>("data not found", HttpStatus.CREATED);
       return new ResponseEntity<>("Fundraiser updated", HttpStatus.ACCEPTED);
       
   }
   @GetMapping("page/{pg}/{si}")
   public Page<Fundraiser> getPage(@PathVariable("pg") int pg,@PathVariable("si") int si){
       return fundraiserService.pageNation(pg,si);
   }
   @GetMapping("page/{pg}/{si}/{name}")
     public Page<Fundraiser> getMethodName(@PathVariable("pg") int pg,@PathVariable("si") int si,@PathVariable("name") String name) {
       return fundraiserService.pageNationSort(pg,si,name);
   }
   @GetMapping("/jplqueryexample/{n}")
   public List<Fundraiser> findByQuantity(@PathVariable("n") int n) {
       return fundraiserService.findByQuantity(n);
   }
   @GetMapping("/nativequeryexample/{n}")
   public List<Fundraiser> findByQuantitygthan(@PathVariable("n") int n) {
       return fundraiserService.findByQuantitygthan(n);
   }

}
