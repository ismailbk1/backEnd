package tn.pfe.rhbackend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("RETRAITE")
public class Retraite extends Demande {

    private  String type_retraite ;

}
