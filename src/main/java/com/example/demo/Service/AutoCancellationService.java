package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Reservation;

@Service
public class AutoCancellationService {

	  @Autowired
	    private ReservationService reservationService;

	    @Autowired
	    private CancellationService cancellationService;

	    // This method runs every day at midnight
	    @Scheduled(cron = "0 0 0 * * ?")
	    public void autoCancelOverdueReservations() {
	        LocalDate today = LocalDate.now();
	        List<Reservation> reservations = reservationService.getAllReservations();

	        for (Reservation reservation : reservations) {
	            // Check if the reservation date is before today and if it is not already cancelled
	            if (reservation.getDateOfJourney().isBefore(today) && reservation.getCancellation() == null) {
	                reservationService.cancelReservation(reservation.getId());
	                System.out.println("Automatically cancelled reservation with PNR: " + reservation.getPnrNumber());
	            }
	        }
	    }
	
}
