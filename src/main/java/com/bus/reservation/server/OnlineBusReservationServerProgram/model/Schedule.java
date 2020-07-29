package com.bus.reservation.server.OnlineBusReservationServerProgram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Bus bus;

	@Column
	private int source;

	@Column
	private int destination;

	@Column
	private String departureTime;

	@Column
	private String arrivalTime;

	@Column
	private String days;
//	
//	@OneToMany
//	private Days day;

	public Schedule() {

	}

	public Schedule(Bus bus, int source, int destination, String departureTime, String arrivalTime, String days) {
		super();
		this.bus = bus;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.days = days;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", bus=" + bus + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", dayList=" + days + "]";
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

}
