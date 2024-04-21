package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import tn.pfe.rhbackend.model.Position;
import tn.pfe.rhbackend.model.Residence;
@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Integer> {
    Residence findByIdresidence(Integer idResidence);
}

