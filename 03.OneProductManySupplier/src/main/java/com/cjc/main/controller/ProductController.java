package com.cjc.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Product;
import com.cjc.main.model.Supplier;
import com.cjc.main.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService ps;
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product)
	{
		ps.saveData(product);
		return "insert successfully";
	}
	
	@PostMapping("/saveSupplier")
	public String saveSupplier(@RequestBody Supplier supplier)
	{
		ps.saveSupplier(supplier);
		return "Supplier Data insert Successfuly";
	}
	
	@PutMapping("/updateuser/{id}")
	public Product updateputdata(@PathVariable  int id, @RequestBody Product product)
	{
		System.out.println("id is:-"+ id);
		System.out.println("Object id is:" +product.getId());
		ps.saveData(product);
		return product;
	}
	
	
	
	@RequestMapping("/getAllData")
	public Iterable<Product> getAllData()
	{
		Iterable<Product> list=ps.displayAllData();
		return list;
		
	}
	
	@GetMapping("/getSingleProductData/{id}")
	public Optional<Product>  getSingleData(@PathVariable int id)
	{
		Optional<Product> list=ps.getSingleProductData(id);
	return list;
	}
	
	@GetMapping("/getSingleSupplierId/{supplierId}")
	public Optional<Supplier>  getSingleSupplierId(@PathVariable int supplierId)
	{
		Optional<Supplier> list=ps.getSingleSupplierId(supplierId);
	return list;
	}
	
	
	@RequestMapping("/getAllSupplierData")
	public Iterable<Supplier> getAllSupplier()
	{
		Iterable<Supplier> list=ps.displayAllSupplierData();
		return list;
		
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id )
	{
		ps.deleteData(id);
		return "delete Successfully";
	}

}
