package tn.pfe.rhbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="demande")
 public   class Demande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iddemande;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String motif_depart;

   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date date_demande;

   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date date_depart_persivible;

    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent agent;
@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "code_residence")
    private Residence residence;

@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "besoin_id")
    private Besoin besoin;



}
