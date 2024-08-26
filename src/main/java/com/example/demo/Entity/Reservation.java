package com.example.demo.Entity;



import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
	    private Cancellation cancellation;
	 
	    public Cancellation getCancellation() {
		return cancellation;
	}
	public void setCancellation(Cancellation cancellation) {
		this.cancellation = cancellation;
		
	}
		@ManyToOne
	    private User user;

	    @ManyToOne
	    private Train train;

	    private LocalDate dateOfJourney;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Train getTrain() {
			return train;
		}
		public void setTrain(Train train) {
			this.train = train;
		}
		public LocalDate getDateOfJourney() {
			return dateOfJourney;
		}
		public void setDateOfJourney(LocalDate dateOfJourney) {
			this.dateOfJourney = dateOfJourney;
		}
		public String getFromPlace() {
			return fromPlace;
		}
		public void setFromPlace(String fromPlace) {
			this.fromPlace = fromPlace;
		}
		public String getToPlace() {
			return toPlace;
		}
		public void setToPlace(String toPlace) {
			this.toPlace = toPlace;
		}
		public String getPnrNumber() {
			return pnrNumber;
		}
		public void setPnrNumber(String pnrNumber) {
			this.pnrNumber = pnrNumber;
		}
		private String fromPlace;
	    private String toPlace;
	    private String pnrNumber;
	
}
