package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Film;
import com.example.demo.entities.Ticket;

public interface TicketService {
    public List<Ticket> getAllTickets();
    public Ticket saveFilm(Ticket ticket);
    public Ticket getTicketId(Integer id);
    public Ticket editTicket(Ticket ticket);
    public Long countTicket();
    public void deleteTicketById(Integer id);
    public Long countTicketsBetweenDatesJPQL(Date dateDebut, Date dateFin);
}
