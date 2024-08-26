package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cancellation;
import com.example.demo.Entity.Reservation;
import com.example.demo.Repository.CancellationRepository;
import com.example.demo.Repository.ReservationRepository;
import com.example.demo.Repository.TrainRepository;

@Service
public class ReservationService {
@Autowired
	private CancellationRepository cancellationRepository;
	 @Autowired
	    private ReservationRepository reservationRepository;

	    @Autowired
	    private TrainRepository trainRepository;

	    public Reservation bookReservation(Reservation reservation) {
	    	
	    	
	        String pnr = UUID.randomUUID().toString().substring(0, 8);
	        reservation.setPnrNumber(pnr);
	        return reservationRepository.save(reservation);
	    }

	    public Optional<Reservation> getReservationByPnr(String pnrNumber) {
	        return reservationRepository.findByPnrNumber(pnrNumber);
	    }

	    public List<Reservation> getAllReservations() {
	        return reservationRepository.findAll();
	    }
	    
	    public void cancelReservation(Long reservationId) {
	        // Fetch the reservation
	        Reservation reservation = reservationRepository.findById(reservationId)
	            .orElseThrow(() -> new RuntimeException("Reservation not found"));

	        Cancellation cancellation = new Cancellation();
	        cancellation.setPnrNumber(reservation.getPnrNumber());
	        cancellation.setCancelledDate(LocalDate.now());
	        cancellation.setStatus("Cancelled");
	        cancellation.setReservation(reservation);

	        
	        cancellationRepository.save(cancellation);

	        reservation.setCancellation(cancellation);
	        reservationRepository.save(reservation);
	    }
	    
	   
	    
	   
	    
}
