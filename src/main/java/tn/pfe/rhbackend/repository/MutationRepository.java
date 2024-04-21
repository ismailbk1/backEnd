package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.rhbackend.model.Mutation;

@Repository
public interface MutationRepository extends JpaRepository<Mutation, Integer> {
}
