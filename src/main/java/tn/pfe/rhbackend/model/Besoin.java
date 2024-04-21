package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //pour crée table
@Getter
@Setter
@NoArgsConstructor // constructeur par défaut sans paramétre
@AllArgsConstructor // constructeur aves paramétre
@Table(name = "besoin")
public class Besoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idbesoin  ;
    private Integer nb_besoin_par_residence ;



    //many-to-one" avec l'entité Résidence, ce qui signifie qu'un besoin appartient à une seule résidence mais une résidence peut avoir plusieurs besoins
    @ManyToOne
    @JoinColumn(name = "code_residence")
    private Residence residence;


    @Column(name = "id_demande")
    private Long id_demande;
}
