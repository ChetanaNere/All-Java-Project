package com.cjc.main.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Product {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private int id;
private String productName;
private String productDetails;
private String productPrice;
private String availableQuantity;

@ManyToMany(cascade=CascadeType.ALL)
private List<Supplier>supplier;


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

public String getProductDetails() {
	return productDetails;
}

public void setProductDetails(String productDetails) {
	this.productDetails = productDetails;
}

public String getProductPrice() {
	return productPrice;
}

public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
}

public List<Supplier> getSupplier() {
	return supplier;
}

public void setSupplier(List<Supplier> supplier) {
	this.supplier = supplier;
}

public String getAvailableQuantity() {
	return availableQuantity;
}

public void setAvailableQuantity(String availableQuantity) {
	this.availableQuantity = availableQuantity;
}



}
