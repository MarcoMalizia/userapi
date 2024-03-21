package com.marco.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marco.userapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//@Query("SELECT usr FROM users usr WHERE usr.fooIn = ?1")
    //User findByEmail (String email);
	
	@Query(value = "SELECT * FROM users WHERE email_id=?",nativeQuery = true)
    public User findByEmail(String email);

}
