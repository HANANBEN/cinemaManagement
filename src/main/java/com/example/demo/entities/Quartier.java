package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Quartier {
    @Id
    private String nom;
    private String longitude;

    private String latitude;

    private String altitude;
    @ManyToOne
    private Ville ville;
	public Quartier(String nom, String longitude, String latitude, String altitude, Ville ville) {
		super();
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.ville = ville;
	}
	public Quartier() {
		super();
	}
	public Quartier(String nom, String longitude, String latitude, String altitude) {
		super();
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
    
    

}
