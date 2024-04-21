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
@NoArgsConstructor   // constructeur par défaut sans paramétre
@AllArgsConstructor // constructeur aves paramétre
@Table(name = "position ")
public class Position  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idposition ;
    private  Integer code_position ;
    private String libelle ;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Agent> agents;

}
