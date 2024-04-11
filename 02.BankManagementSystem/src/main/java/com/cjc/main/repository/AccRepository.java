package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Account;
@Repository
public interface AccRepository extends CrudRepository<Account, Integer>{

	public Account findAllByAccnoAndName(long accno, String name);

	public Account findAllByAccno(long accno);



}
