package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.example.demo.entities.Avis;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idclient;

    private String nom;


    private String prenom;
  
    private String email;

    private String tele;

    public Client(String nom, String prenom, String email, String tele, Login login, Ville ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.login = login;
		this.ville = ville;
	}
    
	
	public Client(String nom, String prenom, String email, String tele) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
	}
	public Client(int idclient, String nom, String prenom, String email, String tele, Login login, Ville ville,
			List<Ticket> tickets, List<com.example.demo.entities.Avis> avis) {
		super();
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.login = login;
		this.ville = ville;
		this.tickets = tickets;
		Avis = avis;
	}
	@OneToOne
    private Login login;

    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "client")
    private List<Avis> Avis;





}
