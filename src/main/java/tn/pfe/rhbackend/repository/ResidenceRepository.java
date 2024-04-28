package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.rhbackend.model.Residence;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Integer> {


    Residence findByCodeResidence(Integer id);

    boolean existsByCodeResidence(Integer id);

    void deleteByCodeResidence(Integer code);
}

