package com.main.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private LocalDateTime start;
  private LocalDateTime end;
  

public Event(String title, LocalDateTime start, LocalDateTime end) {
	super();
	this.id = id;
	this.title = title;
	this.start = start;
	this.end = end;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public LocalDateTime getStart() {
	return start;
}
public void setStart(LocalDateTime start) {
	this.start = start;
}
public LocalDateTime getEnd() {
	return end;
}
public void setEnd(LocalDateTime end) {
	this.end = end;
}

  
  // Getters and Setters
}