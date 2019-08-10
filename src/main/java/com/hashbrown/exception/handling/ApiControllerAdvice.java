package com.hashbrown.exception.handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hashbrown.exception.GroupIsNotExistException;

@ControllerAdvice
public class ApiControllerAdvice {
	
	private Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<?> handle(MethodArgumentNotValidException e) {
		logger.error("Argument is not valid", e);
		ErrorMessage em = new ErrorMessage(HttpStatus.BAD_REQUEST, "Argument is not valid");	
		return ResponseEntity.badRequest().body(em);
		
	}
	
	@ExceptionHandler(GroupIsNotExistException.class)
	protected ResponseEntity<?> handle(GroupIsNotExistException e) {
		logger.error("Group Is Not Exist", e);
		ErrorMessage em = new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
		//return ResponseEntity.badRequest().body(em);
		return ResponseEntity.badRequest().body(em);
	}
}
