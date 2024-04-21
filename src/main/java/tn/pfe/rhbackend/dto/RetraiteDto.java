package tn.pfe.rhbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tn.pfe.rhbackend.model.Status;

import java.util.Date;
@Data
public class RetraiteDto {
    private Integer agent;
    private Integer codeResidence;
    private String typeRetraite;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDemande;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDepartPreversible;
    private String motif;
    private Status status;
}
