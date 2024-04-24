package com.fundraising.donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.donation.model.Fundraiser;
import com.fundraising.donation.repository.FundraiserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Service
public class FundraiserService {
    
    @Autowired
    private FundraiserRepository fundraiserRepository;

    @Transactional
    public String saveFundraiser(Fundraiser fundraiser) {
        fundraiserRepository.save(fundraiser);
        return "Fundraising Request Successful";
    }
    @Transactional(readOnly = true)
    public Fundraiser getFundraiserDetails(String name) {
        return fundraiserRepository.findByName(name);
    }
    @Transactional(readOnly  = true)
    public List<Fundraiser> getAllFundraiserDetails() {
        return fundraiserRepository.findAll();
    }
    @Transactional
    public void deleteFundraiser(String name){
        fundraiserRepository.deleteByName(name);
    }
    public Page<Fundraiser> pageNation(int pagno,int size){
        return fundraiserRepository.findAll(PageRequest.of(pagno, size));
    }

    public Page<Fundraiser> pageNationSort(int pageNo,int size, String name){
     
        return fundraiserRepository.findAll(PageRequest.of(pageNo, size,Sort.by(Direction.DESC,name)));
    }
    public List<Fundraiser> findByQuantity(int a)
    {
        return fundraiserRepository.findByQuantitygreaterthan(a);
    }
    public List<Fundraiser> findByQuantitygthan(int a)
    {
        return fundraiserRepository.findByQuantitygthan(a);
    }
   
}
