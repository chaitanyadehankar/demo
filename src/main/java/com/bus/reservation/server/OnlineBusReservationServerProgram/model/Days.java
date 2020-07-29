package com.bus.reservation.server.OnlineBusReservationServerProgram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Days {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String day;
//
//	@ManyToMany(mappedBy = "day")
//	private Schedule schedule;

	public Days() {

	}

	public Days(String day, Schedule schedule) {
		super();
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

//	public Schedule getSchedule() {
//		return schedule;
//	}
//
//	public void setSchedule(Schedule schedule) {
//		this.schedule = schedule;
//	}

	@Override
	public String toString() {
		return "Days [id=" + id + ", day=" + day + ", schedule=" + "]";
	}

}
