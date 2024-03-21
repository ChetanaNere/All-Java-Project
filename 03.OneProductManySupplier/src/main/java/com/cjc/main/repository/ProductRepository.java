package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Product;
import com.cjc.main.model.Supplier;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	

	



}
