package com.cjc.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Account;
import com.cjc.main.repository.AccRepository;
import com.cjc.main.service.AccService;
@Service
public class ServiceImpl implements AccService{

	@Autowired
	AccRepository ar;
	
	@Override
	public void saveUser(Account a) {
	ar.save(a);
		
	}

	@Override
	public Account loginCheck(long accno, String name) {
	
		return ar.findAllByAccnoAndName(accno,name);
	}

	@Override
	public Iterable<Account> dispalyAllData() {
		
		return ar.findAll();
	}

	@Override
	public void deleteAcc(Account a) {
	ar.delete(a);
	}

	@Override
	public Account editAcc(long accno) {
		
		return ar.findAllByAccno(accno);
	}

	@Override
	public Account depositeMoney(long accno) {
		
		return ar.findAllByAccno(accno);
	}

	@Override
	public Account addBal(double dp,Account a) {
		double nb=a.getBalence()+dp;
		a.setBalence(nb);
		return a;
	}

	@Override
	public Account withdraw(long accno) {
		
		return ar.findAllByAccno(accno);
	}

	@Override
	public Account subBal(double wd, Account a) {
		double d=a.getBalence()-wd;
		a.setBalence(d);
		return a;
	}

}
