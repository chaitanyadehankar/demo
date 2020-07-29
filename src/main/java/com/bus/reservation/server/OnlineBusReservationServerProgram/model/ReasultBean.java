package com.bus.reservation.server.OnlineBusReservationServerProgram.model;

import java.util.Set;

public class ReasultBean {

	private int busId;
	private String operatorName;
	private int totalSeats;
	private int availableSeats;
	private String arrivalTime;
	private String departureTime;
	private String source;
	private String destination;
	private String travelDate;
	private Set<Integer> bookedSeats;

	public ReasultBean() {

	}

	public ReasultBean(int busId, String operatorName, int totalSeats, int availableSeats, String arrivalTime,
			String departureTime, String source, String destination, String travelDate) {
		super();
		this.busId = busId;
		this.operatorName = operatorName;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
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

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

//	public int getVailableSeats() {
//		return availableSeats;
//	}
//
//	public void setVailableSeats(int availableSeats) {
//		this.availableSeats = availableSeats;
//	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTrivalDate() {
		return travelDate;
	}

	public void setTrivalDate(String trivalDate) {
		this.travelDate = trivalDate;
	}

	@Override
	public String toString() {
		return "ReasultBean [busId=" + busId + ", operatorName=" + operatorName + ", totalSeats=" + totalSeats
				+ ", availableSeats=" + availableSeats + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", source=" + source + ", destination=" + destination + ", trivalDate=" + travelDate
				+ "]";
	}

}
