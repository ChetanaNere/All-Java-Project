package com.cjc.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Product;
import com.cjc.main.repository.UserRepository;
import com.cjc.main.servicei.ServiceI;


@Service
public class ServiceImpl implements ServiceI {
	@Autowired
	UserRepository ur;

	@Override
	public Iterable<Product> displayAllData() {
		
		return ur.findAll();
	}

	
	public void saveUser(Product u) {
		ur.save(u);
		
	}


	public void deleteData(int id) {
	ur.deleteById(id);
		
	}
	
}
