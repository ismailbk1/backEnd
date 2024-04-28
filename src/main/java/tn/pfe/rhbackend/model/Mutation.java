package tn.pfe.rhbackend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("MUTATION")
public class Mutation extends Demande {
     private String residence_muter;
}
