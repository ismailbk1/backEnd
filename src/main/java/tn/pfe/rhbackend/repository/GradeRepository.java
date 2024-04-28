package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.rhbackend.model.Grade;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade , Integer> {



    Optional<Grade> findByCodeGrade(Integer id);

    boolean existsByCodeGrade(Integer id);
}
