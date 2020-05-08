package com.felipedeveloper.reportapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedeveloper.reportapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
