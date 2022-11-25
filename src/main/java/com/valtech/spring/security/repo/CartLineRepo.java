package com.valtech.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.CartLine;

@Repository
public interface CartLineRepo extends JpaRepository<CartLine, Integer> {
	
	
	CartLine findByprodid(int prodid);

}
