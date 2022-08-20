package com.zee.zee5app.advice;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exceptions.InvalidEmailException;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.RecordNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(RecordAlreadyExistsException.class) // to handle global level exception

	public ResponseEntity<?> RecordAlreadyExistsExceptionHandler(RecordAlreadyExistsException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "Record already existed" + e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}

	@ExceptionHandler(InvalidEmailException.class) // to handle global level exception

	public ResponseEntity<?> InvalidEmailExceptionHandler(InvalidEmailException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "email already existed " + e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(InvalidIdException.class) // to handle global level exception

	public ResponseEntity<?> InvalidIdExceptionHandler(InvalidIdException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "Id not existed " + e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	@ExceptionHandler(RecordNotFoundException.class) // to handle global level exception

	public ResponseEntity<?> RecordNotFoundExceptionHandler(RecordNotFoundException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "Record not existed " + e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
}
