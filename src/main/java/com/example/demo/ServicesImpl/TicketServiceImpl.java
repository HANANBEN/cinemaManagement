package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Projectionfilm;
import com.example.demo.entities.Ticket;
import com.example.demo.repository.ProjectionfilmRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.TicketService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketrep;
    private ProjectionfilmRepository projectrep;
    
    
    public TicketServiceImpl(TicketRepository ticketrep, ProjectionfilmRepository projectrep) {
		super();
		this.ticketrep = ticketrep;
		this.projectrep = projectrep;
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
    @Override
    public int calculateNumberOfTicketsBetweenDates(LocalDate startDate, LocalDate endDate) {
        // Convertir LocalDate en java.sql.Date
        java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
        java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);

        // Récupérer les projections de film entre les dates spécifiées
        List<Projectionfilm> projections = projectrep.findByDateProjectionBetween(
                sqlStartDate, sqlEndDate);

        int totalTickets = 0;

        // Vérifier si des projections ont été trouvées
        if (projections != null) {
            // Pour chaque projection récupérée, comptez le nombre de tickets associés
            for (Projectionfilm projection : projections) {
                List<Ticket> tickets = ticketrep.findByProjectionFilm(projection);
                if (tickets != null) {
                    totalTickets += tickets.size();
                }
            }
        }

        return totalTickets;
    }}
