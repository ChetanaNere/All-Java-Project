package com.cjc.main.servicei;

import com.cjc.main.model.Product;

public interface ServiceI {

	public Iterable<Product> displayAllData();

	public void saveUser(Product u);

	public void deleteData(int id);

}
