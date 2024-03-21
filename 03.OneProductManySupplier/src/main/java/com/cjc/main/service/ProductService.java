package com.cjc.main.service;


import java.util.Optional;

import com.cjc.main.model.Product;
import com.cjc.main.model.Supplier;


public interface ProductService {
	
	public void saveData(Product product);

	
	public Iterable<Product> displayAllData();


	public Optional<Product>  getSingleProductData(int id);


	public void deleteData(int id);


	public void saveSupplier(Supplier supplier);


	public Optional<Supplier> getSingleSupplierId(int supplierId);


	public Iterable<Supplier> displayAllSupplierData();


	
	//public Product addSupplierToProduct(int productId, Supplier supplier) ;
//
   // public Optional<Product> getSingleProductData(int id);
//
	//public Product getSingleProductData(int id);
//	
//	public Supplier getSingleSupplierData(int supplierId);



}
