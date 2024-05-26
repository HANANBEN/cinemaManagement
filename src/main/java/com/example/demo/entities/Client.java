package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@Builder
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idclient;

    private String nom;


    private String prenom;

    private String email;

    private String tele;

    @OneToOne
    private Login login;

    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "client")
    private List<Avis> Avis;
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public List<Avis> getAvis() {
		return Avis;
	}
	public void setAvis(List<Avis> avis) {
		Avis = avis;
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
	public Client(int idclient, String nom, String prenom, String email, String tele) {
		super();
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
	}
    
    
    
}
