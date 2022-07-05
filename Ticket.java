package com.example.user.entity;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	Integer  pnr;
	@Column
	String name;
	@Column
	Integer age;
	@Column
	String gender;
	@Column
	String email;
	@Column
	Integer seat_count;
	@Column
	String flight_number;
	@Column
	String startdate;
	@Column
	String enddate;
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Integer pnr, String name, Integer age, String gender, String email, Integer seat_count,
			String flight_number,String startdate,	String enddate) {
		super();
		this.pnr = pnr;
		this.name = name;
		this.age = age;
		this.startdate=startdate;
		this.enddate=enddate;
		this.gender = gender;
		this.email = email;
		this.seat_count = seat_count;
		this.flight_number = flight_number;
	}
	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email
				+ ", seat_count=" + seat_count + ", flight_number=" + flight_number + ",startdate=" + startdate + ",enddate=" + enddate + "]";
	}
	public Integer getPnr() {
		return pnr;
	}
	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSeat_count() {
		return seat_count;
	}
	public void setSeat_count(Integer seat_count) {
		this.seat_count = seat_count;
	}
	public String getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	
}
