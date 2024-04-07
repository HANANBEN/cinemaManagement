package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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



}
