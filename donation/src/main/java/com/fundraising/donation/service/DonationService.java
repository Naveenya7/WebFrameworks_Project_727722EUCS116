package com.fundraising.donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundraising.donation.model.Donar;
import com.fundraising.donation.model.Donation;
import com.fundraising.donation.repository.DonarRepository;
import com.fundraising.donation.repository.DonationRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationService {
    
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonarRepository donarRepository;

    public String saveDonation(Donation donation) {
        donationRepository.save(donation);
        return "Donation Successful";
    }
    @Transactional(readOnly=true)
    public Donation getDonationDetails(String email) {
        return donationRepository.findByEmail(email);
        
    }

    public List<Donation> getAllDonationDetails() {
        return donationRepository.findAll();
    }
    @Transactional
    public void deleteDonation(String email){
        donationRepository.deleteByEmail(email);
    }

    public String mapDonationByCity(Donation donation){
        Donar donar=donation.getDonar();
        Donar cityobj=donarRepository.findByCityEndsWith(donar.getCity());
        donation.getDonar().setId(cityobj.getId());
        donationRepository.save(donation);
        return "Donation successful";
    }

   
}
