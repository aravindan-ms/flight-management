package com.example.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.entity.Admin;



@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	 AdminRepository repo;
	
	@Override
	public Integer saveAdmin(Admin admin)
	{
		Admin admin2=repo.save(admin);
		
		return admin2.getId();
	
	}

}
