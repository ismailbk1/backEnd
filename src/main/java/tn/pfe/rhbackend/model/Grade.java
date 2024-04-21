package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity //pour crée table
@Getter
@Setter
@NoArgsConstructor // constructeur par défaut sans paramétre
@AllArgsConstructor // constructeur aves paramétre
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgrade ;
    private  Integer code_grade ;
    private String libelle ;

    //@OneToMany(mappedBy = "grade"), ce qui signifie qu'un objet Grade peut avoir plusieurs objets Agent
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Agent> agents;


}