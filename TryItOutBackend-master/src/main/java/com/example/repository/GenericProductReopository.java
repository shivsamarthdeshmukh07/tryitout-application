package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
public interface GenericProductReopository extends JpaRepository<Product,Integer>{
	
	
	@Query(value = "SELECT * FROM product_table WHERE STATUS != 'DELETED'",nativeQuery = true)
	public List<Product> findAllWhereStatusIsNotDeleted();
	
	
}
