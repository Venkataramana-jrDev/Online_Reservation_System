package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Cancellation;
import com.example.demo.Entity.Reservation;
import com.example.demo.Entity.User;
import com.example.demo.Service.CancellationService;
import com.example.demo.Service.ReservationService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class DashBoardController {
@Autowired
	private UserService userService;
@Autowired
private ReservationService reservationService;
@Autowired
private CancellationService cancellationService;
	
@GetMapping("/Dashboard")
public String dashboard ( Model model) {
    
	

    List<Reservation> reservations = reservationService.getAllReservations();
	    //model.addAttribute("cancellations", cancellations);
	
    User loggedInUser = userService.getCurrentUser(); 
    model.addAttribute("User", loggedInUser);

    
   // model.addAttribute("reservations", reservationService.getAllReservations());
    
    reservations.forEach(reservation -> {
        System.out.println("Reservation PNR: " + reservation.getPnrNumber());
        System.out.println("Cancellation Status: " + (reservation.getCancellation() != null ? reservation.getCancellation().getStatus() : "Active"));
    });

    model.addAttribute("reservations", reservations);
    
    
       
        return "Dashboard";
     
}
}
