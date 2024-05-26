package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Cinema {
	public Cinema(Integer idcinema, String nom, Integer nbrsalle, Double longitude, Double latitude, Double altitude,
			Boolean isaffected) {
		super();
		this.idcinema = idcinema;
		this.nom = nom;
		this.nbrsalle = nbrsalle;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.isaffected = isaffected;
	}

	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idcinema;
    private String nom;
    private Integer nbrsalle;
    private Double longitude , latitude,altitude ;

    public Integer getIdcinema() {
		return idcinema;
	}

	public Cinema() {
		super();
	}

	public void setIdcinema(Integer idcinema) {
		this.idcinema = idcinema;
	}
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbrsalle() {
		return nbrsalle;
	}

	public void setNbrsalle(Integer nbrsalle) {
		this.nbrsalle = nbrsalle;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Boolean getIsaffected() {
		return isaffected;
	}

	public void setIsaffected(Boolean isaffected) {
		this.isaffected = isaffected;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public SuperAdmin getSuperadmin() {
		return superadmin;
	}

	public void setSuperadmin(SuperAdmin superadmin) {
		this.superadmin = superadmin;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Cinema(String nom, Integer nbrsalle, Double longitude, Double latitude, Double altitude,
			Boolean isaffected) {
		super();
		this.nom = nom;
		this.nbrsalle = nbrsalle;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.isaffected = isaffected;
	}

	private Boolean isaffected;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    private SuperAdmin superadmin;

    @OneToOne
    private Gestionnaire gestionnaire;
    @OneToMany(mappedBy = "cinema")
    private List<Salle> salles;
}