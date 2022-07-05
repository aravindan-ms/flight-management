package com.example.admin.service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.entity.Admin;
import com.example.admin.entity.Airline;
import com.example.admin.entity.Schedule;
import com.example.admin.exception.ResourceNotFoundException;


@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	 AirlineRepo repo;
	@Autowired
	ScheduleRepo  schedulerepo;
	@Override
	public Integer saveAirline(Airline airline) {
Airline airline2=repo.save(airline);
		
		return airline2.getId();
	}
//	@Override
//	public Void saveSchedule(Schedule schedule) {
//		if(schedule.getWay().equalsIgnoreCase("OneWay")) {
//		Schedule schedule2=schedulerepo.save(schedule);
//		
//		}else {
//			Schedule schedule3=schedulerepo.save(schedule);
//			schedule3.setSource(schedule.getDestination());	
//			schedule3.setDestination(schedule.getSource());
//			schedulerepo.save(schedule3);
//			}
//		return null;
//		}
		
	@Override
	public Integer saveSchedule(Schedule schedule) {
		Schedule airline2=schedulerepo.save(schedule);
		
		return airline2.getId();
	}
	
	
	@Override
	public Airline getbyId(Integer id) {
		Optional<Airline> entity4=repo.findById(id);
		if(entity4.isPresent()) {
		Airline entitydata=entity4.get();
	
		return entitydata;
	}else {
		throw new ResourceNotFoundException("Airline","id",id);
	}
}

	@Override
	public Schedule getSchedulebyId(Integer id) {
		Optional<Schedule> entity4=schedulerepo.findById(id);
		if(entity4.isPresent()) {
		Schedule entitydata=entity4.get();
	
		return entitydata;
	}else {
		throw new ResourceNotFoundException("Schedule","id",id);
	}}
	@Override
	public List<Airline> getAllFlights(){
	List<Airline> entityall=repo.findAll();
//	List<Order> entity2=entityall.stream().filter(e->e.getEmpid()>10).collect(Collectors.toList());
	return entityall;}

	@Override
	public List<Airline> getAvblFlights(){
	List<Airline> entityall=repo.findAll();	
	List<Airline> entity2=entityall.stream().filter(e->e.getBlock()==true).collect(Collectors.toList());
	return entity2;
		
		
	}
	@Override
	public List<Schedule>  getcheapFlight(){
	List<Schedule> entityall=schedulerepo.findAll();	
	List<Schedule> entity2=entityall.stream().filter(f->f.getPrice() <10000).collect(Collectors.toList());
	return entity2;
	}
//		
//		
//	}
	@Override
	public List<Schedule> getAllSchedules(){
	List<Schedule> entityall=schedulerepo.findAll();
//	List<Order> entity2=entityall.stream().filter(e->e.getEmpid()>10).collect(Collectors.toList());
	return entityall;
	}
	@Override
	public Integer updateAirline(Airline entity, Integer id) {
		Airline e2=	repo.findById(id).orElseThrow( ()->new   ResourceNotFoundException("Airline","id",id));;
//	Airline e2=e1.get();
		e2.setDestination(entity.getDestination());
		e2.setSource(entity.getSource());
		e2.setFlight_name(entity.getFlight_name());
		e2.setFlight_number(entity.getFlight_number());
	
	
		
		repo.save(e2);
		return e2.getId();
	}
	@Override
	public Integer updateSchedule(Schedule entity, Integer id) {
		Schedule e2=	schedulerepo.findById(id).orElseThrow( ()->new   ResourceNotFoundException("Schedule","id",id));;
//	Airline e2=e1.get();
		e2.setDestination(entity.getDestination());
		e2.setSource(entity.getSource());
		e2.setFlight_name(entity.getFlight_name());
		e2.setFlight_number(entity.getFlight_number());
		e2.setStart_time(entity.getStart_time());
		e2.setEnd_time(entity.getEnd_time());
	
		e2.setPrice(entity.getPrice());
		schedulerepo.save(e2);
		return e2.getId();
	}
	@Override
	public void deleteAirline(Integer id) {
	repo.deleteById(id);
	}
	@Override
	public void deleteSchedule(Integer id) {
	schedulerepo.deleteById(id);
	}
	@Override
	public List<Schedule> SearchFlight(String Source,String destination){
	List<Schedule> air=schedulerepo.findBySourceAndDestination(Source, destination);
	
	return air;
	}
	
	@Override
	public List<Schedule> SearchFlightbyvalues(String source,String destination,String way,String startdate, String enddate){
		List<Schedule> air=schedulerepo.findAll();
		
			System.out.println(air);
//		List<Schedule> result1=	air.stream().filter(a->a.getWay().equalsIgnoreCase(way) && a.getSource().equalsIgnoreCase(source) && a.getDestination().equalsIgnoreCase(destination)&& a.getStartdate().equalsIgnoreCase(startdate)&&  a.getStartdate().equalsIgnoreCase(enddate)).collect(Collectors.toList());
			List<Schedule>  result1	=	schedulerepo.getFlightsbysource(source,destination,way,startdate,enddate);
			System.out.println(result1);
		return result1;
	

	}
	}
