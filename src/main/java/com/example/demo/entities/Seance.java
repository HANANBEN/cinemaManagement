package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity

public class Seance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer idseance;


    private LocalTime heuredebut;
  
    private LocalTime heurefin;
    @ManyToOne
    private Projectionfilm projectionfilm;
    @ManyToOne
    private Salle salle;
	public Seance(Integer idseance, LocalTime heuredebut, LocalTime heurefin, Projectionfilm projectionfilm,
			Salle salle) {
		super();
		this.idseance = idseance;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.projectionfilm = projectionfilm;
		this.salle = salle;
	}
	public Integer getIdseance() {
		return idseance;
	}
	public void setIdseance(Integer idseance) {
		this.idseance = idseance;
	}
	public LocalTime getHeuredebut() {
		return heuredebut;
	}
	public void setHeuredebut(LocalTime heuredebut) {
		this.heuredebut = heuredebut;
	}
	public LocalTime getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(LocalTime heurefin) {
		this.heurefin = heurefin;
	}
	public Projectionfilm getProjectionfilm() {
		return projectionfilm;
	}
	public void setProjectionfilm(Projectionfilm projectionfilm) {
		this.projectionfilm = projectionfilm;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Seance(LocalTime heuredebut, LocalTime heurefin, Projectionfilm projectionfilm, Salle salle) {
		super();
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.projectionfilm = projectionfilm;
		this.salle = salle;
	}
	public Seance(LocalTime heuredebut, LocalTime heurefin) {
		super();
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
	}
	public Seance(LocalTime heuredebut, LocalTime heurefin, Projectionfilm projectionfilm) {
		super();
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.projectionfilm = projectionfilm;
	}
	public Seance(Integer idseance, LocalTime heuredebut, LocalTime heurefin, Salle salle) {
		super();
		this.idseance = idseance;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.salle = salle;
	}
	public Seance() {
		super();
	}



}
