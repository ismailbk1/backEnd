package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.rhbackend.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade , Integer> {


    Grade findByIdgrade(Integer idAgent);
}
