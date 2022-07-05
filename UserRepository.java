package com.example.user.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.user.entity.Ticket;

public interface UserRepository extends JpaRepository<Ticket,Integer> {
	List<Ticket> findByEmail(String email);

//	List<Ticket> findByTicket(Ticket smartWatches);
//	@Query("SELECT CASE WHEN COUNT(s)> 0 THEN TRUE ELSE FALSE END FROM Ticket s WHERE s.pnr = :pnr")
//	Boolean isPersonExistsById(int i);

}
