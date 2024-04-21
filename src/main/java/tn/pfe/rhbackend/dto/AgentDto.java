package tn.pfe.rhbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDto {
     private  Integer id_agent  ;
    private Integer matricule_agent;
    private String nomprenom;

    private String sexe;

    private String situation_familiale;

    private String situation_administrative;
    private LocalDate date_entree_en_activite;
    private LocalDate date_naissance;
    private LocalDate date_debut_position;
    private Integer code_grade ;
    private  Integer code_residence ;
    private  Integer code_position ;
}
