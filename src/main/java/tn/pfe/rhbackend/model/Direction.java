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
@Table(name = "direction ")
public class Direction {
    @Id
    @Column(unique = true, length = 20)

    private  Integer codeDirection ;
    private String libelle ;

    //

    @OneToMany(mappedBy = "direction")
    private List<Residence> residences;
}
