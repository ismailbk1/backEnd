package tn.pfe.rhbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class CongeDto implements Serializable {




    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date_debut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date_fin;
    private Integer nb_jour;
    private String type;
    private String code_conge;


    private Integer agent;

}
