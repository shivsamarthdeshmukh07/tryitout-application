package com.example.controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductAddDto;
import com.example.dto.UserProductUpdateRequestDto;
import com.example.entity.Product;
import com.example.exception.UserException;
import com.example.service.ProductServiceImple;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductServiceImple productService;
	
	@PostMapping("/add")
	public Product addproduct(@RequestBody Product p) {
		p.setStatus("Added");
		try {
			
			return productService.addProduct(p);
		}
		catch(UserException e) {
			throw e;		
			
		}	
	}
	@PostMapping("/add-product")
	public boolean addProductInfo( ProductAddDto product) {
		
		Product p = new Product();
		System.out.println(product.getId());
		try {
		
//		if(product.getId()== -1) {
//			p.setName(product.getName());
//			p.setBrand(product.getBrand());
//			p.setCategory(product.getCategory());
//			p.setColour(product.getColour());
//			p.setGender(product.getGender());
//			p.setPrice(product.getPrice());
//			p.setDescription(product.getDescription());
//			p.setQuantity(product.getQuantity());
//			p.setStatus("Added");
//
//			p = productService.addProduct(p);
//			
//			String fileName =  p.getProductId() + "-" + product.getProductImg().getOriginalFilename();
//			
//			FileCopyUtils.copy(product.getProductImg().getInputStream(), new FileOutputStream("C:/Users/dac6/Downloads/TryItOutFrontEnd-master/TryItOutFrontEnd-master/src/Product-Images/" + fileName));
//
//			p.setProductImg(fileName);
//			
//			p = productService.addProduct(p);
//		}
//		else {
			p.setProductId(product.getId());
			p.setName(product.getName());
			p.setBrand(product.getBrand());
			p.setCategory(product.getCategory());
			p.setColour(product.getColour());
			p.setGender(product.getGender());
			p.setPrice(product.getPrice());
			p.setDescription(product.getDescription());
			p.setQuantity(product.getQuantity());
			p.setStatus("Added");
			
			String fileName =  p.getProductId() + "-" + product.getProductImg().getOriginalFilename();
			
			FileCopyUtils.copy(product.getProductImg().getInputStream(), new FileOutputStream("C:/Users/dac6/Downloads/TryItOutFrontEnd-master/TryItOutFrontEnd-master/src/Product-Images/" + fileName));

			p.setProductImg(fileName);
			
			p = productService.addProduct(p);

		//}
	
		
		}
		catch(Exception e) {
			throw new UserException("Sorry there is error in adding products");
		}
		return true;
	}
	
	@PostMapping("/all-products")
	public List<Product> featchAllProducts(){
		try {
		return productService.getAllProducts();
		}
		catch(UserException e) {
			return null;
		}
	}
	@PutMapping("/delete-product/{id}")
	public boolean deleteproduct(@PathVariable int id) {
		try {
		
			return productService.deleteProduct(id); 
		}
		catch(UserException e) {
			return false;
		}
	}
}
