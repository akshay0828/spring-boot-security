package com.valtech.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.spring.security.entity.CartLine;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.repo.CartLineRepo;

@Service
public class CartLineServiceImpl implements CartLineService {
	
	@Autowired
	private CartLineRepo cartLineRepo;

	@Override
public void createCartLine(CartLine cartline) {
		cartLineRepo.save(cartline);
	}
	
	@Override
	public List<CartLine> findAll() {
		return cartLineRepo.findAll();
	}
	@Override
	public CartLine findById(int id) {
		return cartLineRepo.findById(id).get();
	}
	@Override
	public CartLine findByProId(int prodid) {
		return cartLineRepo.findByprodid(prodid);
		
	}

}
