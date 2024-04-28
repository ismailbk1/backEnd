package tn.pfe.rhbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class MutationDto {

    private Integer agent;
    private String typeRetraite;
    private Integer codeResidenceactuel;
    private Integer codeResidencemuter;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDemande;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDepartPreversible;
    private String motif;
}
