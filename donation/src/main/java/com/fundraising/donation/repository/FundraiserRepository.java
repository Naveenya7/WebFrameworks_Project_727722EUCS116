package com.fundraising.donation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundraising.donation.model.Fundraiser;


@Repository
public interface FundraiserRepository extends JpaRepository<Fundraiser, Integer>{
    Fundraiser findByName(String name);
    void deleteByName(String name);
    @Query(
        value = "SELECT f From Fundraiser f Where f.goalamount>:val")
        List<Fundraiser> findByQuantitygreaterthan(@Param("val") int a);
    @Query(value="Select * from Fundraiser where goalamount>:val", nativeQuery = true)
    List<Fundraiser> findByQuantitygthan(@Param("val")int a);
}

