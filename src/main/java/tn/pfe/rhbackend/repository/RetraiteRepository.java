package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.rhbackend.model.Retraite;

@Repository
public interface RetraiteRepository extends JpaRepository<Retraite, Integer> {
}
