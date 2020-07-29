package com.bus.reservation.server.OnlineBusReservationServerProgram.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Bus {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;

	@Column
	private String operatorName;

	@Column
	private int capacity;

	@ElementCollection
	private List<Integer> costlySeats;

	@Column
	private int costlySeatPrice;

	@Column
	private int pricePerSeat;

	@Transient
	private Schedule schedule;

	public Bus() {

	}

	public Bus(String operatorName, int capacity, List<Integer> costlySeats, int costlySeatPrice, int pricePerSeat,
			Schedule schedule) {
		super();
		this.operatorName = operatorName;
		this.capacity = capacity;
		this.costlySeats = costlySeats;
		this.costlySeatPrice = costlySeatPrice;
		this.pricePerSeat = pricePerSeat;
		this.schedule = schedule;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Integer> getCostlySeats() {
		return costlySeats;
	}

	public void setCostlySeats(List<Integer> costlySeats) {
		this.costlySeats = costlySeats;
	}

	public int getCostlySeatPrice() {
		return costlySeatPrice;
	}

	public void setCostlySeatPrice(int costlySeatPrice) {
		this.costlySeatPrice = costlySeatPrice;
	}

	public int getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(int pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", operatorName=" + operatorName + ", capacity=" + capacity + ", costlySeats="
				+ costlySeats + ", costlySeatPrice=" + costlySeatPrice + ", pricePerSeat=" + pricePerSeat
				+ ", schedule=" + schedule + "]";
	}

}
