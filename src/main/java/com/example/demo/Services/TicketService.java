package com.example.demo.Services;

import com.example.demo.Entities.*;

import java.util.List;

public interface TicketService {
    public List<Ticket> getAllTickets();
    public Ticket saveFilm(Ticket ticket);
    public Ticket getTicketId(Integer id);
    public Ticket editTicket(Ticket ticket);
    public Long countTicket();
    public void deleteTicketById(Integer id);
}
