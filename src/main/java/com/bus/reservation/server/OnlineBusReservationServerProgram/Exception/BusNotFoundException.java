package com.bus.reservation.server.OnlineBusReservationServerProgram.Exception;

public class BusNotFoundException extends RuntimeException {

	public BusNotFoundException() {
		super("Bus not found for the given path !!");
	}
}
