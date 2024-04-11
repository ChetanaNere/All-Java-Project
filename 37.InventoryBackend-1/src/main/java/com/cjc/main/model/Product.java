package com.cjc.main.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id ;
   private String productName;
   private String  productPrice;
   private String  productDetails;
   private int   availableQuantity;
 
 @ManyToMany(cascade = CascadeType.ALL)
 private  Set<Supplier> supplier;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductPrice() {
	return productPrice;
}

public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
}

public String getProductDetails() {
	return productDetails;
}

public void setProductDetails(String productDetails) {
	this.productDetails = productDetails;
}

public int getAvailableQuantit() {
	return availableQuantity;
}

public void setAvailableQuantit(int availableQuantity) {
	this.availableQuantity = availableQuantity;
}

public Set<Supplier> getSupplier() {
	return supplier;
}

public void setSupplier(Set<Supplier> supplier) {
	this.supplier = supplier;
}


 
}
