package com.fundraising.donation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundraising.donation.model.Donar;
import com.fundraising.donation.service.DonarService;

@RestController
@RequestMapping("/donor")
public class DonorController {
    @Autowired DonarService donarService;
    @PostMapping("/post")
    public String saveDonar(@RequestBody Donar donar) {
        return donarService.saveDonar(donar);
    }
    @DeleteMapping("/delete")
    public String deleteDonar(@RequestParam int id){
        if(donarService.getDonarDetails(id)!=null)
        donarService.deleteDonar(id);
        else
        return "No data found";
        return "Donar deleted";
    }
    @GetMapping("/get")
    public Donar getDonarDetails(@RequestParam int id) {
       return donarService.getDonarDetails(id);
   }
   @GetMapping("/getAll")
    public List<Donar> getDonationDetails() {
        return donarService.getAllDonorDetails();
    }

    @PutMapping("/update")
   public ResponseEntity<String> updateDonor(@RequestBody Donar newDonar){
       Donar oldDonar=donarService.getDonarDetails(newDonar.getId());
       if(oldDonar!=null){
           
           oldDonar.setCity(newDonar.getCity());
           oldDonar.setCountry(newDonar.getCountry());
           donarService.saveDonar(oldDonar);
           
       }
       else
       return new ResponseEntity<>("data not found", HttpStatus.CREATED);
       return new ResponseEntity<>("Donor updated", HttpStatus.ACCEPTED);
       
   }
}
