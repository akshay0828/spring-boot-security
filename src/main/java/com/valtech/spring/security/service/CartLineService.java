package com.valtech.spring.security.service;

import java.util.List;

import com.valtech.spring.security.entity.CartLine;

public interface CartLineService {

	List<CartLine> findAll();

	void createCartLine(CartLine cartline);



	CartLine findByProId(int prodid);

	CartLine findById(int id);

}