package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity //pour crée table
@Getter
@Setter
@NoArgsConstructor // constructeur par défaut sans paramétre
@AllArgsConstructor // constructeur aves paramétre
@Table(name = "Conge")
public class Conge {
    @Id

    @Column(unique = true, length = 20)
    private Long codeConge;



    private Date date_debut;
    private Date date_fin;
    private Integer nb_jour;
    private String type;

    @ManyToOne
    @JoinColumn(name = "matricule_agent ")
    private Agent agent;
}


