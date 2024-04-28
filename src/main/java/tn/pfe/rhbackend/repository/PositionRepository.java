package tn.pfe.rhbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Grade;
import tn.pfe.rhbackend.model.Position;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Integer> {


    Optional<Position> findByCodePosition(Integer id);

    boolean existsByCodePosition(Integer id);

    void deleteByCodePosition(Integer id);
}
