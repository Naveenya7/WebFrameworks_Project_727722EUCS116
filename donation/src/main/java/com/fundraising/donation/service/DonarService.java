package com.fundraising.donation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundraising.donation.model.Donar;
import com.fundraising.donation.repository.DonarRepository;

import jakarta.transaction.Transactional;

@Service
public class DonarService {
    @Autowired
    private DonarRepository donarRepository;
    public String saveDonar(Donar donar) {
        donarRepository.save(donar);
        return "Donar details saved";
    }

    @Transactional
    public Donar getDonarDetails(int id) {
        return donarRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteDonar(int id){
        donarRepository.deleteById(id);
    }
    public List<Donar> getAllDonorDetails() {
        return donarRepository.findAll();
    }
}
