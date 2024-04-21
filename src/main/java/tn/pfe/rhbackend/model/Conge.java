package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity //pour crée table
@Getter
@Setter
@NoArgsConstructor // constructeur par défaut sans paramétre
@AllArgsConstructor // constructeur aves paramétre
@Table(name = "Conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcongee;
    private String code_conge;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private Integer nb_jour;
    private String type;

    @ManyToOne
    @JoinColumn(name = "matricule_agent ")
    private Agent agent;
}


