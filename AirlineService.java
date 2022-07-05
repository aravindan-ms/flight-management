package com.example.admin.service;

import java.util.List;
import java.util.Optional;

import com.example.admin.entity.Admin;
import com.example.admin.entity.Airline;
import com.example.admin.entity.Schedule;

public interface AirlineService {
	public Integer saveAirline(Airline airline);

	Integer updateAirline(Airline entity, Integer id);

	Integer saveSchedule(Schedule schedule);

	List<Airline> getAllFlights();

	Airline getbyId(Integer id);

	void deleteAirline(Integer id);

	List<Schedule> SearchFlight(String Source, String Destination);

	List<Schedule> getAllSchedules();

	void deleteSchedule(Integer id);

	List<Airline> getAvblFlights();

//	Optional<Airline> getcheapFlight();

	Schedule getSchedulebyId(Integer id);

	Integer updateSchedule(Schedule entity, Integer id);

	

	List<Schedule> SearchFlightbyvalues(String source, String destination, String way, String startdate,
			String enddate);
	
	
static String Return() {
	return "name";	
	}

List<Schedule> getcheapFlight();
}
