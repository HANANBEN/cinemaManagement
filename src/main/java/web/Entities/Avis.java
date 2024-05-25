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
public class Avis {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idavis;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Film film;
}
