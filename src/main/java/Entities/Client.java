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
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idclient;

    private String nom;


    private String prenom;

    private String email;

    private String tele;

    @OneToOne
    private Login login;

    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;






}
