package com.cjc.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Product;
import com.cjc.main.model.Supplier;
import com.cjc.main.repository.ProductRepository;
import com.cjc.main.repository.SupplierRepository;
import com.cjc.main.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository pr;
	
	@Autowired
	SupplierRepository sr;
	
	@Override
	public void saveData(Product product) {
		pr.save(product);	
	}

	@Override
	public Iterable<Product> displayAllData() {
		 return pr.findAll();
	}

	@Override
	public Optional<Product> getSingleProductData(int id) {
	  return pr.findById(id);
	 
	}

	
	@Override
	public void deleteData(int id) {
		 pr.deleteById(id);
	}


	public void saveSupplier(Supplier supplier) {
		sr.save(supplier);
	}

	@Override
	public Optional<Supplier> getSingleSupplierId(int supplierId) {
	return sr.findBySupplierId(supplierId);
	}

	public Iterable<Supplier> displayAllSupplierData() {
	
		return sr.findAll();
	}
	
	
//	@Override
//	public Product addSupplierToProduct(int productId, Supplier supplier) {
//		Product prod = pr.findByProductId(productId);
//		prod.getSupplier().add(supplier);
//		pr.save(prod);
//		return null;
//	}

}
