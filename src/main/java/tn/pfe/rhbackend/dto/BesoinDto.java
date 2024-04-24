package tn.pfe.rhbackend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.pfe.rhbackend.model.Residence;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BesoinDto {
    private Integer nb_besoin_par_residence ;
private Residence residence;


    private Long id_demande;
}
