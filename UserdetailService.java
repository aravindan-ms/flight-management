package com.example.admin.security.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.admin.entity.Admin;
import com.example.admin.service.AdminRepository;

@Service
public class UserdetailService implements UserDetailsService {
@Autowired
private AdminRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin user=repo.findByusername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
	public Admin getAccountByUserName(String username)
	{
		return repo.findByusername(username);
	}

}
