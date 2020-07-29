package com.bus.reservation.server.OnlineBusReservationServerProgram.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.reservation.server.OnlineBusReservationServerProgram.model.Bus;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.ReasultBean;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.RequestBean;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.Schedule;
import com.bus.reservation.server.OnlineBusReservationServerProgram.repository.DaoRepo;

@RestController
public class Home {

	@Autowired
	DaoRepo dao;

	@GetMapping("/getAllBuses")
	public List<Bus> test() {
		return dao.getBusInfo();
	}

	@GetMapping("/searchSchedule/{source}/{destination}/{date}")
	public List<Schedule> searchSchedule(@PathVariable("source") String s, @PathVariable("destination") String d,
			@PathVariable("date") String date) {
		return dao.searchSchedule(s, d, date);
	}

	@GetMapping("/selectSchedule/{id}")
	public ReasultBean selectSchedule(@PathVariable("id") int id) {
		return dao.selectSchedule(id);
	}

	@PostMapping("/bookSeats/")
	public void bookSeats(@RequestBody RequestBean reqBean) {
		dao.bookSeats(reqBean);
	}
}
