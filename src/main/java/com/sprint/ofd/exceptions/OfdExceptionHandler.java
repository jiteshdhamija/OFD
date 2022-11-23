package com.sprint.ofd.exceptions;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.sprint.ofd.entity.ErrorResponse;

@ControllerAdvice
public class OfdExceptionHandler {
	
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(RestaurantNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(ItemNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AddressNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CategoryNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CartNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	@ExceptionHandler(BillNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(BillNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(LoginNotFoundException exception) {
		// Create ErrorResponse Obj
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
}
