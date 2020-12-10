package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException(ResourceNotFoundException ex){
		ErrorMessage errMsg=new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.NOT_FOUND.value());
		errMsg.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errMsg,HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorMessage> handleInvalidEmailException(InvalidInputException ex){
		ErrorMessage errMsg=new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errMsg.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errMsg,HttpStatus.OK);
	}
	
	@ExceptionHandler(DuplicateRecordFoundException.class)
	public ResponseEntity<ErrorMessage> handleDuplicateRecordFoundException(DuplicateRecordFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errorMessage,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
