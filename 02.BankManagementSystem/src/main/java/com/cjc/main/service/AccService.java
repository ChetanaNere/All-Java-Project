package com.cjc.main.service;

import com.cjc.main.model.Account;

public interface AccService {

	public void saveUser(Account a);

	public Account loginCheck(long accno, String name);

	public Iterable<Account> dispalyAllData();

	public void deleteAcc(Account a);

	public Account editAcc(long accno);
//
   public Account depositeMoney(long accno);
//
	public Account addBal(double dp, Account a);

	public Account withdraw(long accno);



	public Account subBal(double wd, Account a);

	

	

	





}
