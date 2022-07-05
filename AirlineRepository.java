package com.example.user.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.user.entity.Airline;
import com.example.user.entity.Ticket;

public interface AirlineRepository  extends JpaRepository<Airline,Integer> {
//	@Query(nativeQuery=true,value="select  *" + 
//		
//			"FROM `airline_booking`.`flight` where `flight`.`Source`=:Source and `flight`.`Destination`=:Destination ;\r\n" + 
//			" ")
//	List<Airline> getFlightDetails(String Source,String Destination);
List<Airline>  findBySourceAndDestination(String source,String destination);

@Query(nativeQuery = true,value="SELECT flight_number FROM airline_booking.flight")
String[] getFlightNumbers();


}
