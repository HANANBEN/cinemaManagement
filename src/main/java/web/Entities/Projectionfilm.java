package web.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Projectionfilm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idprojection;
    private LocalDate dateprojection;

    @ManyToOne
    private Film film;

    @OneToMany(mappedBy = "projectionfilm")
    private List<Seance> seances;

    @OneToMany(mappedBy = "projectionfilm")
    private List<Ticket> tickets;

	public Integer getIdprojection() {
		return idprojection;
	}

	public void setIdprojection(Integer idprojection) {
		this.idprojection = idprojection;
	}

	public LocalDate getDateprojection() {
		return dateprojection;
	}

	public void setDateprojection(LocalDate dateprojection) {
		this.dateprojection = dateprojection;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Projectionfilm() {
		super();
	}

	public Projectionfilm(LocalDate dateprojection) {
		super();
		this.dateprojection = dateprojection;
	}
    
}
