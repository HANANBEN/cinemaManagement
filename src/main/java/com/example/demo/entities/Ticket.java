package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idticket;
    private Double prix;
    private Double codepayement;
    @ManyToOne
    private Client client;
    @OneToOne
    private Place place;
    @ManyToOne
    private Projectionfilm projectionfilm;
	public Ticket(Integer idticket, Double prix, Double codepayement, Client client, Place place,
			Projectionfilm projectionfilm) {
		super();
		this.idticket = idticket;
		this.prix = prix;
		this.codepayement = codepayement;
		this.client = client;
		this.place = place;
		this.projectionfilm = projectionfilm;
	}



}
