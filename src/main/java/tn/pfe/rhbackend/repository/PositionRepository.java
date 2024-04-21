package tn.pfe.rhbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Grade;
import tn.pfe.rhbackend.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByIdposition(Integer idPosition);

}
