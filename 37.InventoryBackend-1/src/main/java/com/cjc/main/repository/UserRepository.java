package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.cjc.main.model.Product;


public interface UserRepository extends CrudRepository<Product, Integer>{

	

}
