package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Integer> {
}
