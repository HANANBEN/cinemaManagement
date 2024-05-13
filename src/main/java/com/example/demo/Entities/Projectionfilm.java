package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity

public class Projectionfilm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idprojection;
    private Date dateprojection;
    private double prix;
    @ManyToOne
    private Film film;
    @OneToMany(mappedBy = "projectionfilm")
    private List<Seance> seances;
    @OneToMany(mappedBy = "projectionfilm")
    private List<Ticket> tickets;
	public Projectionfilm(Integer idprojection, Date dateprojection, double prix, Film film, List<Seance> seances,
			List<Ticket> tickets) {
		super();
		this.idprojection = idprojection;
		this.dateprojection = dateprojection;
		this.prix = prix;
		this.film = film;
		this.seances = seances;
		this.tickets = tickets;
	}
	public Projectionfilm(Integer idprojection, Date dateprojection, double prix) {
		super();
		this.idprojection = idprojection;
		this.dateprojection = dateprojection;
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Projectionfilm [idprojection=" + idprojection + ", dateprojection=" + dateprojection + ", prix=" + prix
				+ ", film=" + film + "]";
	}
	public Projectionfilm() {
		super();
	}
	public Integer getIdprojection() {
		return idprojection;
	}
	public void setIdprojection(Integer idprojection) {
		this.idprojection = idprojection;
	}
	public Date getDateprojection() {
		return dateprojection;
	}
	public void setDateprojection(Date dateprojection) {
		this.dateprojection = dateprojection;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public List<Seance> getSeances() {
		return seances;
	}
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Projectionfilm(Date dateprojection, double prix, Film film) {
		super();
		this.dateprojection = dateprojection;
		this.prix = prix;
		this.film = film;
	}
	public Projectionfilm( Date dateprojection, double prix, Film film, List<Seance> seances,
			List<Ticket> tickets) {
		super();
		
		this.dateprojection = dateprojection;
		this.prix = prix;
		this.film = film;
		this.seances = seances;
		this.tickets = tickets;
	}



}
