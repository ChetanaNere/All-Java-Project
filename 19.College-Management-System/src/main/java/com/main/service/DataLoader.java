package com.main.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.model.Event;
import com.main.repository.EventRepository;

@Component
public class DataLoader implements CommandLineRunner {
  @Autowired
  private EventRepository eventRepository;

  @Override
  public void run(String... args) throws Exception {
    eventRepository.save(new Event("Today's Event", LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
    eventRepository.save(new Event("Tomorrow's Event", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(2)));
  }
}