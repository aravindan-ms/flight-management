package com.example.admin.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.admin.entity.Airline;
import com.example.admin.entity.Schedule;

public interface ScheduleRepo  extends JpaRepository<Schedule,Integer> {
	List<Schedule>  findBySourceAndDestination(String source,String destination);
		@Query(nativeQuery = true,value="SELECT * FROM airline_booking.schedule where source=:source and destination=:destination AND way=:way and startdate=:startdate and enddate=:enddate")
	List<Schedule> getFlightsbysource(String source,String destination,String way,String startdate,String enddate);
}
