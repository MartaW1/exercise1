package com.martaw.exercise.repository;


import com.martaw.exercise.model.EbayToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EbayTokenRepository extends JpaRepository<EbayToken, Integer> {
}