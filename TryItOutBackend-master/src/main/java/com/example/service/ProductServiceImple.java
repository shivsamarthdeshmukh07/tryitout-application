package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.exception.UserException;
import com.example.repository.GenericProductReopository;
import com.example.repository.GenericUserProductRepo;

@Service
@Transactional
public class ProductServiceImple implements ProductService {
	
	@Autowired
	private GenericProductReopository productRepo;

	public Product addProduct(Product p) {
		
		try {
			//System.out.println(p.getDescription().length());
			return productRepo.save(p);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new UserException("Unsuccessfull!! Please try again");
		}
		
	}
	
	public List<Product> getAllProducts(){
		
		try {
//	 		return productRepo.findAll();
			return productRepo.findAllWhereStatusIsNotDeleted();
	 	
		}
		catch(Exception e) {
		e.printStackTrace();
			throw new UserException("Products are not found!!");
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		Product p = null;
		
		try {
		
			p=productRepo.findById(id).get();
			p.setStatus("Deleted");
			productRepo.save(p);
			return true;	
		}
		catch(Exception e) {
			throw new UserException("The Product was not deleted");
		}
		
	}


	
}
