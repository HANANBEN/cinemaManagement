package Entities;

import jakarta.persistence.*;

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

    private String nom;

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
