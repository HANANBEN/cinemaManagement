package com.example.demo.entities;

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
    private Cinema cinema;


    @OneToMany(mappedBy = "salle")
    private List<Place> places;
    @OneToMany(mappedBy = "salle")
    private List<Seance> seances;
    
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
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		cinema = cinema;
	}
	

	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public Salle(int idsalle, String nom, int nbrplace, boolean isconfig, boolean isdispo,
			com.example.demo.entities.Cinema cinema,
			List<Place> places) {
		super();
		this.idsalle = idsalle;
		this.nom = nom;
		this.nbrplace = nbrplace;
		this.isconfig = isconfig;
		this.isdispo = isdispo;
		cinema = cinema;
	
		this.places = places;
	}
	public Salle() {
		super();
	}
	public Salle(int idsalle, String nom, int nbrplace, boolean isconfig, boolean isdispo) {
		super();
		this.idsalle = idsalle;
		this.nom = nom;
		this.nbrplace = nbrplace;
		this.isconfig = isconfig;
		this.isdispo = isdispo;
	}
	
    


}