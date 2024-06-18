package com.main.repositoryy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

//	public User findByUsernameAndPasword(String username,String password);

	public User findByUsernameAndPassword(String username, String password);

}
