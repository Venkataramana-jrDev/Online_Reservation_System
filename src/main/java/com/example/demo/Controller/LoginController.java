package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Reservation;
import com.example.demo.Entity.User;
import com.example.demo.Service.ReservationService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class LoginController {
	 @Autowired
	    private UserService userService;
	 @Autowired
	 private  ReservationService  reservationService;

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }
//	    @GetMapping("/Dashboard")
//	    public String dashboard(Model model) {
//	    	
//	    	 
//	         
//	    	return "Dashboard";
//	    }

	    @PostMapping("/login")
	    public String login(HttpSession session,User user1 ,@RequestParam String username, @RequestParam String password, Model model) {
	        User user = userService.authenticate(username, password);
	        if (user != null) {
	        	 session.setAttribute("loggedInUser", user);
	        	 
	        	
	        	 model.addAttribute("reservations", reservationService.getAllReservations());
	            return "Dashboard";
	        }
	        model.addAttribute("error", "Invalid username or password");
	        return "login";
	    }
	    
	    
}
