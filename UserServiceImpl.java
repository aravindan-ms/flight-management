package com.example.user.Service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.exception.ResourceNotFoundException;

import com.example.user.entity.Airline;
import com.example.user.entity.Ticket;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;
	
	@Autowired
	AirlineRepository airlinerepo;

	@Override
	public Integer saveAirline(Ticket ticket) {
		Ticket ticket2=repo.save(ticket);
		
		return ticket2.getPnr();
	}

	@Override
	public Ticket getbypnr(Integer pnr) {
		Optional<Ticket> entity4=repo.findById(pnr);
		if(entity4.isPresent()) {
		Ticket entitydata=entity4.get();
	
		return entitydata;
	}else {
		throw new ResourceNotFoundException("ticket","pnr",pnr);
	}
}
	@Override
	public List<Ticket> getTicket(String email){
	List<Ticket> entity=repo.findByEmail(email);
//	List<Order> entity2=entityall.stream().filter(e->e.getEmpid()>10).collect(Collectors.toList());
	if(entity.isEmpty()) {
		throw new ResourceNotFoundException("ticket","email",email);
	}
	
	return entity;
		
	}
	@Override
	public String[] getFlightnumbers(){
		String[] entityall=airlinerepo.getFlightNumbers();
//	List<Order> entity2=entityall.stream().filter(e->e.getEmpid()>10).collect(Collectors.toList());
	return entityall;}
		
	@Override
	public List<Ticket> getAllTickets(){
	List<Ticket> entityall=repo.findAll();
//	List<Order> entity2=entityall.stream().filter(e->e.getEmpid()>10).collect(Collectors.toList());
	return entityall;
		
		
	}
	
	@Override
	public void deleteTicket(Integer pnr) {
	repo.deleteById(pnr);
	}
	
	@Override
	public List<Airline> SearchFlight(String Source,String Destination){
	List<Airline> air=airlinerepo.findBySourceAndDestination(Source, Destination);
	List<Airline> airline=air.stream().filter(a->a.getBlock()==true).collect(Collectors.toList());
	return airline;
	}
}

