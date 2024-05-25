package web.Entities;

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

}
