package com.anandhu.PollingAppBackend.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anandhu.PollingAppBackend.models.User;
import com.anandhu.PollingAppBackend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		
		User user = repository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(()->
				new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));
		
		return UserPrincipal.create(user);
	}
	
	
	public UserDetails loadUserById(Long id)
	{
		User user = repository.findById(id).orElseThrow(
				()-> new UsernameNotFoundException("User not found with id : " + id));
		return UserPrincipal.create(user);
	}

}
