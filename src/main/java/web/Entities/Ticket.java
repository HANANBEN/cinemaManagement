package web.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idticket;
    private Double prix;
    private Double codepayement;
    @ManyToOne
    private Client client;
    @OneToOne
    private Place place;
    @ManyToOne
    private Projectionfilm projectionfilm;
	public Ticket(Double prix, Double codepayement) {
		super();
		this.prix = prix;
		this.codepayement = codepayement;
	}
	public Integer getIdticket() {
		return idticket;
	}
	public void setIdticket(Integer idticket) {
		this.idticket = idticket;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Double getCodepayement() {
		return codepayement;
	}
	public void setCodepayement(Double codepayement) {
		this.codepayement = codepayement;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public Projectionfilm getProjectionfilm() {
		return projectionfilm;
	}
	public void setProjectionfilm(Projectionfilm projectionfilm) {
		this.projectionfilm = projectionfilm;
	}
	public Ticket() {
		super();
	}
    
    



}
