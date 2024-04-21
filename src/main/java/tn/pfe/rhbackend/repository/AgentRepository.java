package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
