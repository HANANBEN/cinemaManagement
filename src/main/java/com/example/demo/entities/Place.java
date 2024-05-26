package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idplace;
    private Integer numero;
    private Double longitude;
    private Double latitude;
    private Double altitude;
    private Boolean isdispo;
    @ManyToOne
    private Salle salle;
	public Place(Integer idplace, Integer numero, Double longitude, Double latitude, Double altitude, Boolean isdispo,
			Salle salle) {
		super();
		this.idplace = idplace;
		this.numero = numero;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.isdispo = isdispo;
		this.salle = salle;
	}
	public Place() {
		super();
	}
	public Integer getIdplace() {
		return idplace;
	}
	public void setIdplace(Integer idplace) {
		this.idplace = idplace;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	public Boolean getIsdispo() {
		return isdispo;
	}
	public void setIsdispo(Boolean isdispo) {
		this.isdispo = isdispo;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

    
}