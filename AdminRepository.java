package com.example.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	Admin findByusername(String username);

}
