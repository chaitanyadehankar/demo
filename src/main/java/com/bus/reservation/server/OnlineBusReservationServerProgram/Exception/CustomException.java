package com.bus.reservation.server.OnlineBusReservationServerProgram.Exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<Object> handleBusNotFoundException(BusNotFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Bus Not Found !");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> defaultExceptionHandler(Exception e) {

		ErrorMessage eresponse = new ErrorMessage(e.getMessage(), "Something went wrong");

		return new ResponseEntity<ErrorMessage>(eresponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

class ErrorMessage {

	private String msg;

	private String detail;

	public ErrorMessage(String msg, String detail) {
		super();
		this.msg = msg;
		this.detail = detail;
	}

}
