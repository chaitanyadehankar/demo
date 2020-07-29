package com.bus.reservation.server.OnlineBusReservationServerProgram.repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bus.reservation.server.OnlineBusReservationServerProgram.Exception.BusNotFoundException;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.Booking;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.Bus;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.Locations;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.ReasultBean;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.RequestBean;
import com.bus.reservation.server.OnlineBusReservationServerProgram.model.Schedule;

@Component
@Transactional
public class DaoRepo {

	@Autowired
	EntityManager em;

	public List<Bus> getBusInfo() {
		List<Bus> bus = em.createQuery("select b from Bus b", Bus.class).getResultList();
		if (bus.isEmpty()) {
			throw new BusNotFoundException();
		}
		return bus;
	}

	public List<Schedule> searchSchedule(String source, String destination, String date) {

		LocalDate dt = LocalDate.parse(date);
		DayOfWeek dayOfWeek = dt.getDayOfWeek();
		System.out.println("Day = " + dayOfWeek);

		Query query1 = em.createNativeQuery("select * from locations where location = ? ", Locations.class);
		query1.setParameter(1, source);

		Query query2 = em.createNativeQuery("select * from locations where location = ? ", Locations.class);
		query2.setParameter(1, destination);

		Locations l1, l2;
//		try {
		l1 = (Locations) query1.getSingleResult();
		l2 = (Locations) query2.getSingleResult();
//		} catch (Exception e) {
//
//			throw new Exception();
//			// throw new WebApplicationException(
//			// Response.status(Response.Status.NOT_FOUND).entity("Bus Not
//			// Available").build());
//		}

//		System.out.println("Source ID = " + l1.getId() + " destination Id = " + l2.getId());

//		if (l1 == null || l2 == null) {
//			throw new WebApplicationException(
//					Response.status(Response.Status.NOT_FOUND).entity("Bus Not Available").build());
//		}

		Query query = em.createNativeQuery("select * from schedule where source = ? and destination = ?  ",
				Schedule.class);
		query.setParameter(1, l1.getId());
		query.setParameter(2, l2.getId());
		List<Schedule> list = query.getResultList();

		ListIterator<Schedule> itr = list.listIterator();
		while (itr.hasNext()) {
			if (!(itr.next().getDays().contains(dayOfWeek.toString()))) {
				itr.remove();
			}
		}

		return list;

	}

	public ReasultBean selectSchedule(int id) {

		Query query = em.createNativeQuery("select * from Booking where schedule_id = ?", Booking.class);
		query.setParameter(1, id);
		Booking booking = (Booking) query.getSingleResult();

		System.out.println("Booking = " + booking);

		Locations source = em.find(Locations.class, booking.getSchedule().getSource());
		Locations destination = em.find(Locations.class, booking.getSchedule().getDestination());

		ReasultBean bean = new ReasultBean();

		bean.setBusId(booking.getSchedule().getBus().getBusId());
		bean.setOperatorName(booking.getSchedule().getBus().getOperatorName());
		bean.setTotalSeats(booking.getSchedule().getBus().getCapacity());
		bean.setAvailableSeats(booking.getAvailableSeats());
		bean.setBookedSeats(booking.getBookedSeats());
		bean.setArrivalTime(booking.getSchedule().getArrivalTime());
		bean.setDepartureTime(booking.getSchedule().getDepartureTime());
		bean.setSource(source.getLocation());
		bean.setDestination(destination.getLocation());
		bean.setTrivalDate(booking.getBookingDate());

		return bean;
	}

	@Transactional
	public void bookSeats(RequestBean bean) {
		System.out.println("Request Bean = " + bean.toString());
		Query q1 = em.createNativeQuery("select * from Booking where booking_date = ? and schedule_id = ?",
				Booking.class);
		q1.setParameter(1, bean.getDate());
		q1.setParameter(2, bean.getScheduleId());
		Booking booking = (Booking) q1.getSingleResult();

		if (booking != null) {

			if (booking.getAvailableSeats() - bean.getSeatNumbers().size() > 0) {
				if (booking.getBookedSeats().removeAll(bean.getSeatNumbers())) {
					System.out.println("Overlapping Seats !!");
				} else {
//					em.getTransaction().begin();
					booking.setAvailableSeats(booking.getAvailableSeats() - bean.getSeatNumbers().size());
					booking.addSeats(bean.getSeatNumbers());
					em.persist(booking);
//					em.getTransaction().commit();
					System.out.println("Booking Done !!!!!!!");
				}
			} else {
				System.out.println("Selected seats are greater than available");
			}
		}
	}
}
