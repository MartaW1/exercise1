package com.martaw.exercise.repository;

import com.martaw.exercise.model.EbayQueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EbayRequestRepository extends JpaRepository<EbayQueryRequest, Integer> {
}