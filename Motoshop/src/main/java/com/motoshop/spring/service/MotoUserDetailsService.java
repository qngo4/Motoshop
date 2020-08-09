package com.motoshop.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.motoshop.spring.entity.User;
import com.motoshop.spring.repository.UserRepository;
import com.motoshop.spring.security.MotoUserPrincipal;

@Service
public class MotoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		// TODO need grant authorities
		MotoUserPrincipal motoUserPrincipal = new MotoUserPrincipal(user);
		
		return motoUserPrincipal;
	}

}
