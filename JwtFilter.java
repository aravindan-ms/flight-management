package com.example.admin.security.JwtFilter;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import  com.example.admin.security.services.UserdetailService;
import com.example.admin.security.util.JwtUtil;
@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserdetailService service;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	String authourisationheader=request.getHeader("Authorization");
	String token=null;
	String username=null;
	
	if(authourisationheader !=null && authourisationheader.startsWith("Bearer ") ) {
		token=authourisationheader.substring(7);
		username=jwtUtil.extractUsername(token);
				
	}
	if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
UserDetails userdetails=service.loadUserByUsername(username);
if(jwtUtil.ValidateToken(token,userdetails)) {
	UsernamePasswordAuthenticationToken token2=new UsernamePasswordAuthenticationToken(userdetails,userdetails.getAuthorities());
	token2.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(token2);
}
}filterChain.doFilter(request, response);}}
