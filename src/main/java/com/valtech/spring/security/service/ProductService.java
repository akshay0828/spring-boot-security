package com.valtech.spring.security.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.security.entity.Products;

import com.valtech.spring.security.repo.ProductRepository;

@Service
//@Transactional(propagation=Propagation.SUPPORTS)
public class ProductService implements product {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	//@Transactional(propagation = Propagation.SUPPORTS)
	
	public void createProduct(Products products) {
		
//		Products p = new Products();	
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		
		productRepository.save(products);
	}
	
	@Override
	public Products getProduct(int id){
	   return 	productRepository.findById(id);
	}
	
	@Override
	public List<Products> getAllProducts(){
		   return 	productRepository.findAll();
		}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Products updateProduct(Products product) {
		return productRepository.save(product);
	}
	
	public List<Products> getAllproductsbyuser(int userid){
		return productRepository.findByUserid(userid);
	}

	
	public int getuserid(int id){
		return productRepository.findUseridById(id);
	}
	
	public void deleteProduct(int id){
		 productRepository.deleteById(id);
	}


}
