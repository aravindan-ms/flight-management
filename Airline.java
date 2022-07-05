package com.example.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="flight")
public class Airline {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
	@Column
	private	String source;
	@Column
	private	String destination;
	@Column
	private Boolean block;
	@Override
	public String toString() {
		return "Airline [id=" + id + ", source=" + source + ", destination=" + destination + ", block=" + block
				+ ", flight_name=" + flight_name + ", flight_number=" + flight_number + "]";
	}

	public Boolean getBlock() {
		return block;
	}

	public void setBlock(Boolean block) {
		this.block = block;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getsource() {
		return source;
	}

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setsource(String source) {
		this.source = source;
	}


	

	public Airline(Integer id, String source, String destination, Boolean block, String flight_name,
			String flight_number) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.block = block;
		this.flight_name = flight_name;
		this.flight_number = flight_number;
		
	
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	

	
	@Column
	private String flight_name;
	
	@Column
	private String flight_number;


}
