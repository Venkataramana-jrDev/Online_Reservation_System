package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cancellation;
import com.example.demo.Entity.Reservation;
import com.example.demo.Repository.CancellationRepository;
import com.example.demo.Repository.ReservationRepository;

@Service
public class CancellationService {

	
	@Autowired
    private CancellationRepository cancellationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Cancellation> findAll() {
        List<Cancellation> cancellations = cancellationRepository.findAll();
        
        cancellations.forEach(cancellation -> {
            if (cancellation.getStatus() == null) {
                cancellation.setStatus("UnkSnown Status");
            }
        });
        return cancellations;
    }

    
//    public Cancellation findById(Long id) {
//        return cancellationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cancellation not found for id: " + id));
//    }
    
    public Cancellation cancelReservation(String pnrNumber) {
        Optional<Reservation> optReservation = reservationRepository.findByPnrNumber(pnrNumber);
        if (optReservation.isPresent()) {
        	 Reservation reservation = optReservation.get();
            Cancellation cancellation = new Cancellation();
            cancellation.setPnrNumber(pnrNumber);
            cancellation.setCancelledDate(LocalDate.now());
            cancellation.setStatus("Cancelled");
            cancellation.setReservation(reservation);
             cancellationRepository.save(cancellation);
             return cancellation;
        }
        return null;
        
        
}
}
