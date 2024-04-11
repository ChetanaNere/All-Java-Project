package com.cjc.main.controller;

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
import com.cjc.main.servicei.ServiceI;

@RestController

@CrossOrigin("*")
public class ProductController {
	@Autowired
	ServiceI si;
	
	@RequestMapping("/demo")
	public String demo()
	{
		return "Hello Demo";
	}
@PostMapping("/saveProduct")
public String saveProduct(@RequestBody Product product)
{
	
	System.out.println(product);
	si.saveUser(product);
	return "Data insert Successfully";
}

@GetMapping("/getAllData")
public Iterable<Product> getAllData()
{
	Iterable<Product> list=si.displayAllData();
	return list;
}

@DeleteMapping("/deleteData/{id}")
public String deleteData(@PathVariable int id )
{
	si.deleteData(id);
	return "delete Successfully";
}

@PutMapping("/updateuser/{id}")
public Product updateputdata(@PathVariable  int id, @RequestBody Product u)
{
	System.out.println("id is:-"+ id);
	System.out.println("Object id is:" +u.getId());
	si.saveUser(u);
	return u;
}
}
	

