package com.example.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.entity.Admin;
import com.example.admin.entity.Airline;
import com.example.admin.entity.Schedule;
import com.example.admin.service.AdminService;
import com.example.admin.service.AirlineService;






@RestController
@CrossOrigin(origins="*")
public class AdminController {
	@Autowired
	AirlineService service;

	@Autowired
	AdminService adminservice;
	
	@PostMapping("/Admin")
	public Integer CreateAdmin(@RequestBody Admin entity)
	{
		Integer id=adminservice.saveAdmin(entity);
		System.out.println(id);
	
	return id;
}
	@GetMapping("/Schedulesearch/{source}/{destination}")
	public List<Schedule> getDetails(@PathVariable String source,@PathVariable String destination)
	{
		

	return service.SearchFlight(source,destination);
	}
	@GetMapping("/Schedulesearchbyvalue/{source}/{destination}/{way}/{startdate}/{enddate}")
	public List<Schedule> getDetails(@PathVariable String source,@PathVariable String destination,@PathVariable String way,@PathVariable String startdate,@PathVariable String enddate)
	{
		

	return service.SearchFlightbyvalues(source, destination, way,startdate,enddate);
	}
	@PostMapping("/Airline")
	public Integer CreateAirline(@RequestBody Airline entity)
	{
		Integer id=service.saveAirline(entity);
		System.out.println(id);
	
	return id;
}
	@PostMapping("/Schedule")
	public Integer CreateSchedule(@RequestBody Schedule entity)
	{
   Integer id=  service.saveSchedule(entity);
		
	return id;
	
}
	@GetMapping("/Airlineid/{id}")
	public ResponseEntity<?> getAirline(@PathVariable Integer id){
		ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
	try
	{	
		Airline entity=service.getbyId(id);
		 re=new ResponseEntity<>(entity,HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				
				re=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);}
			return re;
			}
	@GetMapping("/Scheduleid/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable Integer id){
		ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
	try
	{	
		Schedule entity=service.getSchedulebyId(id);
		 re=new ResponseEntity<>(entity,HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				
				re=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);}
			return re;
			}
	@GetMapping("/allFlights")
	public List<Airline> getOrderrs(){
		return service.getAllFlights();
		
		
		
	}
	@GetMapping("/avblFlights")
	public List<Airline> getAvblFlights(){
		return service.getAvblFlights();
		
		
		
	}
	@GetMapping("/allSchedules")
	public List<Schedule> getSchedules(){
		return service.getAllSchedules();
		
		
		
	}
	@GetMapping("/cheapflight")
	public List<Schedule> getCheapFlight(){
		return service.getAllSchedules();
		
		
		
	}
	@GetMapping("/cheapflights")
	public List<Schedule> getCheapFlights(){
		return service.getcheapFlight();
		
		
		
	}
	@PutMapping("/updateairline/{id}")
	public ResponseEntity<?> updateairline(@RequestBody Airline entity,@PathVariable Integer id ){
		ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
		try {
			service.updateAirline(entity, id);
			new ResponseEntity<>("Successfully updated the schedule",HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			re=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return re;
		}
	@PutMapping("/updateschedule/{id}")
	public ResponseEntity<?> updateschedule(@RequestBody Schedule entity,@PathVariable Integer id ){
		ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
		try {
			service.updateSchedule(entity, id);
			new ResponseEntity<>("Successfully updated the schedule",HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			re=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return re;
		}

@DeleteMapping("/Flighttid/{id}")
public ResponseEntity<?> deleteTicket(@PathVariable Integer id){
	ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
try {
	service.deleteAirline(id);
}catch(Exception e) {
	e.printStackTrace();
	re=new ResponseEntity<>(HttpStatus.NOT_FOUND);

	
}
return re;
}
@DeleteMapping("/Scheduleid/{id}")
public ResponseEntity<?> deleteSchedule(@PathVariable Integer id){
	ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
try {
	service.deleteSchedule(id);
}catch(Exception e) {
	e.printStackTrace();
	re=new ResponseEntity<>(HttpStatus.NOT_FOUND);

	
}
return re;
}
		
		
	}



