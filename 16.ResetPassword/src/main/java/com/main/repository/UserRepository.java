package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	public User findByUsernameAndPassword(String username, String password);
	public Optional<User> findByEmail(String email);
	Optional<User> findByResetToken(String resetToken);
	 Optional<User> findById(Long id);
}
