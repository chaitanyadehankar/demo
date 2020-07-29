package com.bus.reservation.server.OnlineBusReservationServerProgram.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String bookingDate;

	@OneToOne
	private Schedule schedule;

	@Column
	private int availableSeats;

	@ElementCollection
	private Set<Integer> bookedSeats;

	public Booking() {

	}

	public Booking(String bookingDate, Schedule schedule, int availableSeats, Set<Integer> bookedSeats) {
		super();
		this.bookingDate = bookingDate;
		this.schedule = schedule;
		this.availableSeats = availableSeats;
		this.bookedSeats = bookedSeats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Set<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	
	public void addSeats(Set<Integer> s) {
		this.bookedSeats.addAll(s);
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", schedule=" + schedule + ", availableSeats="
				+ availableSeats + ", bookedSeats=" + bookedSeats + "]";
	}

}
