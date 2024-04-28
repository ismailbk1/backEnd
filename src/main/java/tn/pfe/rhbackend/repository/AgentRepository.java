package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Agent;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    Optional<Agent> findByMatriculeAgent(Long idAgent);
}
