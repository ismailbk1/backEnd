package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="residence")
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idresidence ;
    private Integer code_residence;


    //résidence avec agent
    @OneToMany(mappedBy = "residence", cascade = CascadeType.ALL)
    private List<Agent> agents;

    //résidence avec direction
    @ManyToOne
    @JoinColumn(name = "code_direction")
    private Direction direction;

    ///residence avec besoin
    @OneToMany(mappedBy = "residence")
    private List<Besoin> besoins;

    // residence avec demande

    @OneToMany(mappedBy = "residence")
    private List<Besoin> demandes;

    @OneToMany(mappedBy = "residence")
    private List<Bureau> bureaux;
}