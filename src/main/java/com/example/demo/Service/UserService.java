package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	 private UserRepository userRepository;

	    public User authenticate(String username, String password) {
	        return userRepository.findByUsername(username)
	                .filter(user -> user.getPassword().equals(password))
	                .orElse(null);
	    }

	    private final HttpSession session;

	    public UserService(HttpSession session) {
	        this.session = session;
	    }

	    public User getCurrentUser() {
	      
	        return (User) session.getAttribute("loggedInUser");
	    }
}
