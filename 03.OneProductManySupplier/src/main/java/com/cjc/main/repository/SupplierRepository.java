package com.cjc.main.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cjc.main.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer>{

	Optional<Supplier> findBySupplierId(int supplierId);

	

}
