package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idsalle;



    private String nom;

    private int nbrplace;

    private boolean isconfig;

    private boolean isdispo;

    @ManyToOne
    private Cinema Cinema;

    @ManyToOne
    private Gestionnaire Gestionnaire;
    @OneToMany(mappedBy = "salle")
    private List<Place> places;
    @OneToMany(mappedBy = "salle")
    private List<Seance> Seances;
	public Salle(int idsalle, String nom, int nbrplace, boolean isconfig, boolean isdispo,
			com.example.demo.Entities.Cinema cinema, com.example.demo.Entities.Gestionnaire gestionnaire,
			List<Place> places, List<Seance> seances) {
		super();
		this.idsalle = idsalle;
		this.nom = nom;
		this.nbrplace = nbrplace;
		this.isconfig = isconfig;
		this.isdispo = isdispo;
		Cinema = cinema;
		Gestionnaire = gestionnaire;
		this.places = places;
		Seances = seances;
	}
	public int getIdsalle() {
		return idsalle;
	}
	public void setIdsalle(int idsalle) {
		this.idsalle = idsalle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbrplace() {
		return nbrplace;
	}
	public void setNbrplace(int nbrplace) {
		this.nbrplace = nbrplace;
	}
	public boolean isIsconfig() {
		return isconfig;
	}
	public void setIsconfig(boolean isconfig) {
		this.isconfig = isconfig;
	}
	public boolean isIsdispo() {
		return isdispo;
	}
	public void setIsdispo(boolean isdispo) {
		this.isdispo = isdispo;
	}
	public Cinema getCinema() {
		return Cinema;
	}
	public void setCinema(Cinema cinema) {
		Cinema = cinema;
	}
	public Gestionnaire getGestionnaire() {
		return Gestionnaire;
	}
	public void setGestionnaire(Gestionnaire gestionnaire) {
		Gestionnaire = gestionnaire;
	}
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public List<Seance> getSeances() {
		return Seances;
	}
	public void setSeances(List<Seance> seances) {
		Seances = seances;
	}
	public Salle() {
		super();
	}


}