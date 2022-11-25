package com.valtech.spring.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	Products findById(int id);

}
