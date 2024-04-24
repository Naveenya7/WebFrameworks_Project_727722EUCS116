package com.fundraising.donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundraising.donation.model.Fundraiserbankdetails;
import com.fundraising.donation.repository.FundraiserbankdetailsRepository;

import jakarta.transaction.Transactional;

@Service
public class FundraiserbankdetailsService {
   @Autowired
   private FundraiserbankdetailsRepository fundraiserbankdetailsRepository; 
   public String saveFundraiserbank(Fundraiserbankdetails fundraiserbankdetails) {
    fundraiserbankdetailsRepository.save(fundraiserbankdetails);
    return "saved";
}
   @Transactional
    public Fundraiserbankdetails getFundraiserbankDetails(int id) {
        return fundraiserbankdetailsRepository.findById(id).orElse(null);
    }


}
