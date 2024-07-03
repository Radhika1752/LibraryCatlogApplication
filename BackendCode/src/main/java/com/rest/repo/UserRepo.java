package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
