package com.example.user.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.user.Service.UserService;
import com.example.user.entity.Airline;
import com.example.user.entity.BaseResponse;
import com.example.user.entity.Ticket;



@RestController
@CrossOrigin(origins="*")
//@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/Ticket")
	public Integer CreateTicket(@RequestBody Ticket entity)
	{
		Integer id=service.saveAirline(entity);
		System.out.println(id);
	
	return id;
}
@GetMapping("/Ticketid/{pnr}")
public ResponseEntity<?> getTicket(@PathVariable Integer pnr){
	ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
try
{	
	Ticket entity=service.getbypnr(pnr);
	String value="true";
	 re=new ResponseEntity<>(entity,HttpStatus.OK);
	 return re;
	 
		}
		catch(Exception e) {
			e.printStackTrace();
		
			BaseResponse response=new BaseResponse(false,e.getMessage());
			return ResponseEntity.ok(response);}
		
		}
@GetMapping("/Ticketsearch/{source}/{destination}")
public List<Airline> getDetails(@PathVariable String source,@PathVariable String destination)
{
	

return service.SearchFlight(source,destination);
}
@GetMapping("/FlightNumbers")
public String[] getFlightNumbers()
{
	

return service.getFlightnumbers();
}
@GetMapping("/Ticketsearch/{email}")
public ResponseEntity<?>  getDetails(@PathVariable String email){
ResponseEntity<?> re=new ResponseEntity<>(HttpStatus.OK);
try
{	
	List<Ticket> entity=service.getTicket(email);
	 re=new ResponseEntity<>(entity,HttpStatus.OK);
	 return re;
		}
		catch(Exception e) {
			e.printStackTrace();
			BaseResponse response=new BaseResponse(false,e.getMessage());
			return ResponseEntity.ok(response);}
		
		}


@GetMapping("/allTickets")
public List<Ticket> getOrderrs(){
	return service.getAllTickets();
	
	
	
}

@DeleteMapping("/Ticketid/{pnr}")
public ResponseEntity<Ticket> deleteTicket(@PathVariable Integer pnr){
	ResponseEntity<Ticket> re=new ResponseEntity<>(HttpStatus.OK);
try {
	service.deleteTicket(pnr);
}catch(Exception e) {
	e.printStackTrace();
	re=new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);

	
}
return re;
}
}
