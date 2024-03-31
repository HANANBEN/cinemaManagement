package Entities;
<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
>>>>>>> e11650a740e96be88597eaeb2eab3d86563e4493
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
<<<<<<< HEAD

    private String name;
=======
    private String nom;
>>>>>>> e11650a740e96be88597eaeb2eab3d86563e4493
    private String longitude;

    private String latitude;
    private String altitude;
    @OneToMany(mappedBy = "ville")
    private List<Cinema> cinemas ;
    @OneToMany(mappedBy = "ville")
    private List<Boulvard> Boulbards ;
    @OneToMany(mappedBy = "ville")
    private List<Quartier> Quartiers ;

    @OneToMany(mappedBy ="ville")
    private List<Client> clients ;


}
