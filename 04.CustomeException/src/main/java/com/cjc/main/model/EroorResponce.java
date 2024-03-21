package com.cjc.main.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class EroorResponce {
	
	private String msg;
private Object exceptionClassName;
private Date responseTime;


}
