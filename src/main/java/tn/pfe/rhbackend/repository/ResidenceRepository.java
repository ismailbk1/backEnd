package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Position;
import tn.pfe.rhbackend.model.Residence;

public interface ResidenceRepository extends JpaRepository<Residence, Integer> {
    Residence findByIdresidence(Integer idResidence);
}

