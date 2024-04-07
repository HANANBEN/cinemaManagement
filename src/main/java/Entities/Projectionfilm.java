package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Projectionfilm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idprojection;
    private Date dateprojection;
    @ManyToOne
    private Film film;
    @OneToMany(mappedBy = "projectionfilm")
    private List<Seance> seances;
    @OneToMany(mappedBy = "projectionfilm")
    private List<Ticket> tickets;



}
