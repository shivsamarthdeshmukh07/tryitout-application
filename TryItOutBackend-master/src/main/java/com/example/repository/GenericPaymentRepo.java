package com.example.repository;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.PaymentDetails;

@Repository
public interface GenericPaymentRepo extends JpaRepository<PaymentDetails,String> {

}
