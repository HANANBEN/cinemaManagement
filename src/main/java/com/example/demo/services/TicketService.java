package com.example.demo.services;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Film;
import com.example.demo.entities.Ticket;

@Service
public interface TicketService {
    public List<Ticket> getAllTickets();
    public Ticket saveFilm(Ticket ticket);
    public Ticket getTicketId(Integer id);
    public Ticket editTicket(Ticket ticket);
    public Long countTicket();
    public void deleteTicketById(Integer id);
	

	int calculateNumberOfTicketsBetweenDates(LocalDate startDate, LocalDate endDate);
}
