package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_agent ;
    @Column(  unique = true , length = 20) //spécification du matricule doit étre unique
    private Integer matricule_agent;
    private String nomprenom;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    private SituationFamiliale situation_familiale;
    @Enumerated(EnumType.STRING)
    private SituationAdmin situation_administrative;
    private LocalDate date_entree_en_activite;
    private LocalDate date_naissance;
    private LocalDate date_debut_position;

    //@ManyToOne, ce qui signifie qu'un objet Agent est associé à un seul objet Grade
    @ManyToOne
    @JoinColumn(name = "code_grade ")
    private Grade grade;

    // agent associéà une seul position
    @ManyToOne
    @JoinColumn(name = "code_position ")
    private Position position;

    //demande
    @OneToMany(mappedBy = "agent")
    private List<Demande> demandes;

    //residence
    @ManyToOne
    @JoinColumn(name = "code_residence")
    private Residence residence;

    @OneToMany(mappedBy = "agent")
    private List<Conge> conges;


}
