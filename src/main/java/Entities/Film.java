package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idfilm;

    private String titre;
    @OneToMany(mappedBy = "film")
    private List<Projectionfilm> projectionfilms;





}
