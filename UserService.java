package com.example.user.Service;

import java.util.List;

import com.example.user.entity.Airline;
import com.example.user.entity.Ticket;

public interface UserService {

	Integer saveAirline(Ticket ticket);

	Ticket getbypnr(Integer pnr);

	void deleteTicket(Integer pnr);

	List<Airline> SearchFlight(String Source, String Destination);

	List<Ticket> getAllTickets();

	List<Ticket> getTicket(String email);

	String[] getFlightnumbers();

}
