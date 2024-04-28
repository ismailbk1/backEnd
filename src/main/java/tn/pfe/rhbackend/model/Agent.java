package tn.pfe.rhbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="agent")
public class Agent implements Serializable {
    @Id
    @Column(unique = true, length = 20) // spécification du matricule doit être unique
    private Long matriculeAgent;
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
   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "code_grade ")
    private Grade grade;

    // agent associéà une seul position
    @ManyToOne

    @JoinColumn(name = "code_position ")
    private Position position;

    //demande
    @OneToMany(mappedBy = "agent")
    @JsonIgnore

    private List<Demande> demandes;

    //residence

    @ManyToOne
    @JoinColumn(name = "code_residence")
    private Residence residence;

    @OneToMany(mappedBy = "agent")
    @JsonIgnore

    private List<Conge> conges;


}
