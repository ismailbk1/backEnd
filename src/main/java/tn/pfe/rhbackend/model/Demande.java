package tn.pfe.rhbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="demande")
 public  abstract class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iddemande;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String motif_depart;
    private Date date_demande;
    private Date date_depart_persivible;

    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "code_residence")
    private Residence residence;

    @ManyToOne
    @JoinColumn(name = "besoin_id")
    private Besoin besoin;



}
