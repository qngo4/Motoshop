package com.motoshop.spring.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motoshop.spring.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);
	
}
