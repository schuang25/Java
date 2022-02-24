package com.stephen.authentication.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stephen.authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
