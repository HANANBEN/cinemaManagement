package com.example.demo.entities;


import com.example.demo.entities.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Avis {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idavis;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Film film;
	public Integer getIdavis() {
		return idavis;
	}
	public void setIdavis(Integer idavis) {
		this.idavis = idavis;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Avis(Integer idavis, Client client, Film film) {
		super();
		this.idavis = idavis;
		this.client = client;
		this.film = film;
	}
	public Avis(Client client, Film film) {
		super();
		this.client = client;
		this.film = film;
	}
	public Avis() {
		super();
	}
    
}
