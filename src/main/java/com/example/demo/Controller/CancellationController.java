package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Cancellation;
import com.example.demo.Service.CancellationService;

@Controller
public class CancellationController {

	 @Autowired
	    private CancellationService cancellationService;

	    @GetMapping("/cancel")
	    public String showCancellationForm() {
	        return "cancellationForm";
	    }

	    @PostMapping("/cancel")
	    public String cancelReservation(@RequestParam String pnrNumber, Model model) {
	        Cancellation cancellation = cancellationService.cancelReservation(pnrNumber);
	        if (cancellation != null) {
	            model.addAttribute("message", "Cancellation successful for PNR: " + pnrNumber);
	        } else {
	            model.addAttribute("error", "PNR not found or already cancelled");
	        }
	        return "cancellationConfirmation.jsp";
	    }
	
}
