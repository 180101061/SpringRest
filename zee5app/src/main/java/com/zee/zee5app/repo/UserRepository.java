package com.zee.zee5app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

	Boolean existsByEmail(String email);
	Boolean existsByUserName(String userName);
}
