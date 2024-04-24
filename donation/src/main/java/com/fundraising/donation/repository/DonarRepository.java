package com.fundraising.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundraising.donation.model.Donar;


public interface DonarRepository extends JpaRepository<Donar,Integer> {

    Donar findByCityEndsWith(String city);
    
}
