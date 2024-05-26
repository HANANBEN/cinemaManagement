package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.TicketService;

import java.util.Date;
import java.util.List;
@Service

public class TicketServiceImpl implements TicketService {
	@Autowired
    private TicketRepository ticketrep;
	
    
    public TicketServiceImpl(TicketRepository ticketrep) {
		super();
		this.ticketrep = ticketrep;
	}

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
    public Long countTicketsBetweenDatesJPQL(Date dateDebut, Date dateFin) {
        return ticketrep.countTicketsBetweenDatesJPQL(dateDebut, dateFin);
    }
}
