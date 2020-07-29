package com.bus.reservation.server.OnlineBusReservationServerProgram.model;

import java.util.Set;

public class RequestBean {

	private int scheduleId;
	private String date;
	private Set<Integer> seatNumbers;

	public RequestBean(int scheduleId, String date, Set<Integer> seatNumbers) {
		super();
		this.scheduleId = scheduleId;
		this.date = date;
		this.seatNumbers = seatNumbers;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<Integer> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(Set<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	@Override
	public String toString() {
		return "RequestBean [scheduleId=" + scheduleId + ", date=" + date + ", seatNumbers=" + seatNumbers + "]";
	}

}
