package com.example.demo.entities;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class Ville {
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

	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	public List<Boulvard> getBoulbards() {
		return Boulvards;
	}

	public void setBoulbards(List<Boulvard> boulbards) {
		Boulvards = boulbards;
	}

	public List<Quartier> getQuartiers() {
		return Quartiers;
	}

	public void setQuartiers(List<Quartier> quartiers) {
		Quartiers = quartiers;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Ville() {
		super();
	}

	@Id
    private String nom;
    private String longitude;

    private String latitude;
    private String altitude;
    @OneToMany(mappedBy = "ville")
    private List<Cinema> cinemas ;
    @OneToMany(mappedBy = "ville")
    private List<Boulvard> Boulvards ;
    @OneToMany(mappedBy = "ville")
    private List<Quartier> Quartiers ;

    @OneToMany(mappedBy ="ville")
    private List<Client> clients ;


}
