package com.Userver.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Userver.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
