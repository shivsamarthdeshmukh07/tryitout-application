package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.OrderItem;

@Repository
public interface GenericOrderRepo extends JpaRepository<OrderItem,String> {

}
