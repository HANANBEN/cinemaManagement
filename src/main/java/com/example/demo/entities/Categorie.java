package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Categorie {
    @Id
     private String nom;

    @OneToMany(mappedBy = "categorie")
    private List<Film> films;

	public Categorie(String nom, List<Film> films) {
		super();
		this.nom = nom;
		this.films = films;
	}

	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	public Categorie() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}