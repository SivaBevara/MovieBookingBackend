package com.cg.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.model.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AuthenticationFailureException.class)
	public ResponseEntity<ErrorInfo> handleAuthenticationFailureException(Exception e, HttpServletRequest req) {
		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());
		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.UNAUTHORIZED);
		return responseEntity;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleResourceNotFoundException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleCustomerNotExistingException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}



}
