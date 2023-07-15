package com.Dmartready.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.Dmartready.exception.StockCategoryException;
import com.Dmartready.exception.StockMovementException;
import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyManagementError> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,
			WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(e.getFieldError().toString());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyManagementError> myExceptionHandler(Exception e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyManagementError> noHandlerFoundHandler(NoHandlerFoundException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(StoreLocationException.class)
	public ResponseEntity<MyManagementError> storeLocationExceptionHandler(StoreLocationException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(StoreItemException.class)
	public ResponseEntity<MyManagementError> storeItemExceptionHandler(StoreItemException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(StockMovementException.class)
	public ResponseEntity<MyManagementError> stockMovementExceptionHandler(StockMovementException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(StockCategoryException.class)
	public ResponseEntity<MyManagementError> stockCategoryExceptionHandler(StockCategoryException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
