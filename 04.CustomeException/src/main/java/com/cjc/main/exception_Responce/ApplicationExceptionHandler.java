package com.cjc.main.exception_Responce;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.main.exception.EmployeeNotFoundException;
import com.cjc.main.exception.InvalidDetailsException;
import com.cjc.main.model.EroorResponce;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EroorResponce>  handleEmployeeNotFound(EmployeeNotFoundException e)
	{
//		return new EroorResponce(e.getMessage(), e.getClass(), 
//				new Date());
//		
		EroorResponce er=new EroorResponce(e.getMessage(),e.getClass(),new Date());
		return new ResponseEntity<EroorResponce>(er,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalidDetailsException.class)
	public EroorResponce handleInvalidDetails(InvalidDetailsException ie) {
		return new EroorResponce(ie.getMessage(),ie.getClass(), new Date());
	}
}
