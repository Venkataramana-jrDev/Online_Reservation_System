package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Reservation;
import com.example.demo.Entity.Train;
import com.example.demo.Repository.TrainRepository;
import com.example.demo.Service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
    private ReservationService reservationService;
@Autowired
	private TrainRepository trainRepository;
	
    @GetMapping("/book")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationForm";
    }

    @PostMapping("/booking")
    public String bookReservation(@ModelAttribute Reservation reservation,  @RequestParam Long trainId, Model model) {
    	Train train = trainRepository.findById(trainId).orElse(null);
    	if(train!=null) {
    		reservation.setTrain(train);
    		
        Reservation savedReservation = reservationService.bookReservation(reservation);
        model.addAttribute("message", "Reservation successful! PNR: " + savedReservation.getPnrNumber());
    	}
    	else {
    		 model.addAttribute("error", "Train not found!");
    	        return "reservationForm";
    	}
        return "confirmation";
    }
    
    
	
}
