package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.rhbackend.model.Conge;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Integer> {
}
