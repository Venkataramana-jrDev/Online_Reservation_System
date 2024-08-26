package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long>{
	Optional<Reservation> findByPnrNumber(String pnrNumber);
}
