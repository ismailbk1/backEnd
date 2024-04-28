package tn.pfe.rhbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(unique = true, length = 20)
    private Integer codeResidence;
    private String libelle;

    @JsonIgnore
    //résidence avec agent
    @OneToMany(mappedBy = "residence", cascade = CascadeType.ALL)
    private List<Agent> agents;
    @JsonIgnore
    //résidence avec direction
    @ManyToOne
    @JoinColumn(name = "code_direction")
    private Direction direction;

    @JsonIgnore
    ///residence avec besoin
    @OneToMany(mappedBy = "residence")
    private List<Besoin> besoins;

    // residence avec demande
    @JsonIgnore
    @OneToMany(mappedBy = "residence")
    private List<Besoin> demandes;
    @JsonIgnore
    @OneToMany(mappedBy = "residence")
    private List<Bureau> bureaux;
}