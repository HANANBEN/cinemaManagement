package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Seance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer idseance;

@Temporal(TemporalType.TIMESTAMP)
    private Date heuredebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date heurefin;
    @ManyToOne
    private Projectionfilm projectionfilm;



}
