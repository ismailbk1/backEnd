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
    @Table(name = "bureau")
    public class Bureau {
        @Id
        @GeneratedValue(strategy =GenerationType.IDENTITY)
        private Integer idbureau;
        private Integer code_bureau ;
        private String libelle ;
        private String chiffre_affaire;
        private String nb_agent;
        private String nb_guichet;
        private String nb_transaction;

        @ManyToOne
        @JoinColumn(name = "code_residence")
        private Residence residence;
}
