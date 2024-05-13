package com.example.demo.ServicesImpl;

import com.example.demo.Entities.*;

import org.springframework.stereotype.Service;

import com.example.demo.Repositories.TicketRepository;
import com.example.demo.Services.TicketService;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketrep;
    @Override
    public List<Ticket> getAllTickets() {
        return ticketrep.findAll();
    }

    @Override
    public Ticket saveFilm(Ticket ticket) {
        return ticketrep.save(ticket);
    }

    @Override
    public Ticket getTicketId(Integer id) {
        return ticketrep.findById(id).get();
    }

    @Override
    public Ticket editTicket(Ticket ticket) {
        return ticketrep.save(ticket);
    }

    @Override
    public Long countTicket() {
        return ticketrep.count();
    }

    @Override
    public void deleteTicketById(Integer id) {
         ticketrep.deleteById(id);
    }
}
