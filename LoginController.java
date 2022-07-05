package com.example.admin.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.entity.Admin;
import com.example.admin.entity.AuthResponse;
import com.example.admin.entity.ErrorOuput;
import com.example.admin.entity.Request;

import com.example.admin.security.services.UserdetailService;
import com.example.admin.service.AdminRepository;
import com.example.admin.security.util.JwtUtil;
@CrossOrigin(origins="*")
@RestController
public class LoginController {
	@Autowired
	private UserdetailService service;
	

	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public  ResponseEntity<?> authenticate(@RequestBody Request request)throws Exception
	{
		try {
			Admin admin=service.getAccountByUserName(request.getUsername());
			if(admin!=null) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
			
			String jwt=jwtutil.generateTokens(request.getUsername());
			String role="admin";
			AuthResponse auth=new AuthResponse(jwt,admin.getUsername(),admin.getPassword(),true,"Completed Login successfully",role);
//			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
//			List<String> roles = userDetails.getAuthorities().stream()
//					.map(item -> item.getAuthority())
//					.collect(Collectors.toList());
			return ResponseEntity.ok(auth);
		}
			else {
				ErrorOuput output=new ErrorOuput(false,"Invalid username or password");
				return ResponseEntity.ok(output);
			}}
		catch(Exception ex) {
			ErrorOuput output=new ErrorOuput(false,"Invalid username or password");
			return ResponseEntity.ok(output);
		}
		
	
	}}




