package com.example.demo.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Salle;
import com.example.demo.services.SalleService;
import com.example.demo.services.TicketService;

@Controller
public class StatistiqueController {
	private  SalleService salleService;

  private TicketService ticketService;

	public StatistiqueController(SalleService salleService, TicketService ticketService) {
			super();
			this.salleService = salleService;
			this.ticketService = ticketService;
		}

	@GetMapping("/statistique")
	public String statistique(Model model) {
	   
	    return "statistiquegestionnaire";
	}
	
	@PostMapping("/calculerTauxOccupation")
	public String calculerTauxOccupation(@RequestParam("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut,
	                                     @RequestParam("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin,
	                                     Model model) {
	    long nombreTickets = ticketService.countTicketsBetweenDatesJPQL(
	            Date.from(dateDebut.atStartOfDay(ZoneId.systemDefault()).toInstant()),
	            Date.from(dateFin.atStartOfDay(ZoneId.systemDefault()).toInstant())
	    );

	    // Autres opérations pour obtenir le taux d'occupation global
	    double tauxOccupationGlobal = salleService.calculerTauxOccupationGlobalPourPeriode(dateDebut, dateFin);

	    // Ajout des attributs au modèle
	    model.addAttribute("tauxOccupationGlobal", tauxOccupationGlobal);
	    model.addAttribute("nombreTickets", nombreTickets);
	    model.addAttribute("dateDebut", dateDebut);
	    model.addAttribute("dateFin", dateFin);

	    // Retourner la vue correspondante
	    return "statistiquegestionnaire";
	}



}
