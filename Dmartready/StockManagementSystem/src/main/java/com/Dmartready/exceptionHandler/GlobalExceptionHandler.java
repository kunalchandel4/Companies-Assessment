package com.Dmartready.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.Dmartready.exception.CustomerException;
import com.Dmartready.exception.StockCategoryException;
import com.Dmartready.exception.StockMovementException;
import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;

/**
 * Global exception handler for handling various exceptions in the application.
 * Provides exception handling and returns appropriate error responses.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Exception handler for MethodArgumentNotValidException. Handles validation
	 * errors and returns a custom error response.
	 *
	 * @param e   the MethodArgumentNotValidException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */
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

	/**
	 * Exception handler for CustomerException. Handles customer-related exceptions
	 * and returns a custom error response.
	 *
	 * @param e   the CustomerException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyManagementError> CustomerExceptionHandler(CustomerException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());

		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	/**
	 * Exception handler for generic Exception. Handles generic exceptions and
	 * returns a custom error response.
	 *
	 * @param e   the Exception
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyManagementError> myExceptionHandler(Exception e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for NoHandlerFoundException. Handles the case when no
	 * handler is found for the request and returns a custom error response.
	 *
	 * @param e   the NoHandlerFoundException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyManagementError> noHandlerFoundHandler(NoHandlerFoundException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	/**
	 * Exception handler for StoreLocationException. Handles store location-related
	 * exceptions and returns a custom error response.
	 *
	 * @param e   the StoreLocationException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */

	@ExceptionHandler(StoreLocationException.class)
	public ResponseEntity<MyManagementError> storeLocationExceptionHandler(StoreLocationException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for StoreItemException. Handles store item-related
	 * exceptions and returns a custom error response.
	 *
	 * @param e   the StoreItemException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */
	@ExceptionHandler(StoreItemException.class)
	public ResponseEntity<MyManagementError> storeItemExceptionHandler(StoreItemException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for StockMovementException. Handles stock movement-related
	 * exceptions and returns a custom error response.
	 *
	 * @param e   the StockMovementException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */
	@ExceptionHandler(StockMovementException.class)
	public ResponseEntity<MyManagementError> stockMovementExceptionHandler(StockMovementException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for StockCategoryException. Handles stock category-related
	 * exceptions and returns a custom error response.
	 *
	 * @param e   the StockCategoryException
	 * @param req the WebRequest
	 * @return a ResponseEntity containing the error response
	 */
	@ExceptionHandler(StockCategoryException.class)
	public ResponseEntity<MyManagementError> stockCategoryExceptionHandler(StockCategoryException e, WebRequest req) {

		MyManagementError err = new MyManagementError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
