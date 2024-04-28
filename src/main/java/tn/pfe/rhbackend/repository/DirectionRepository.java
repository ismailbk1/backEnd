package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Direction;

import java.util.Optional;

public interface DirectionRepository extends JpaRepository<Direction, Integer> {
    Optional<Direction> findByCodeDirection(Integer id);

    boolean existsByCodeDirection(Integer id);

    void deleteByCodeDirection(Integer id);
}
