package com.marco.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marco.userapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
