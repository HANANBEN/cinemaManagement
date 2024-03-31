package Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Ville {
    @Id
    private String name;
    private String longitude;

    private String latitude;

    private String altitude;
    @OneToMany(mappedBy = "superadmin")
    private List<SuperAdmin> superadmins ;
    @OneToMany(mappedBy = "ville")
    private List<Ville> villes ;

}
