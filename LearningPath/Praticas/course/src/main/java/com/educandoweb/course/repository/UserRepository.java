package com.educandoweb.course.repository;

import com.educandoweb.course.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// A classe não precisa do @Repository, como o service precisa, pois JpaRepository já tem
public interface UserRepository extends JpaRepository<User, Long> {
}
