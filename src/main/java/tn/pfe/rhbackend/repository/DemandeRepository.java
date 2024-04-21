package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer> {
}

