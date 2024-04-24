package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.dto.AgentDto;
import tn.pfe.rhbackend.model.*;
import tn.pfe.rhbackend.repository.AgentRepository;
import tn.pfe.rhbackend.repository.GradeRepository;
import tn.pfe.rhbackend.repository.PositionRepository;
import tn.pfe.rhbackend.repository.ResidenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ResidenceRepository residenceRepository;
    public List<Agent> getAllAgents() {

       List<Agent> agents=agentRepository.findAll();
     //  System.out.println(agents);
        return agents;
    }

    public Optional<Agent> getAgentByMatricule(Integer id_agent) {
        return agentRepository.findById(id_agent);
    }

    public Agent addAgent(AgentDto agent) {
         Agent newAgent=mapToAgent(agent);

        return agentRepository.save(newAgent);

    }

    private Agent mapToAgent(AgentDto agent) {
        Agent newAgent =new Agent();
        newAgent.setMatricule_agent(agent.getMatricule_agent());
        newAgent.setDate_entree_en_activite(agent.getDate_entree_en_activite());
        newAgent.setNomprenom(agent.getNomprenom());
      //  newAgent.setSexe(agent.getSexe());
        if (agent.getSexe()!= null && agent.getSexe().equals(Sexe.MALE)){
            newAgent.setSexe(Sexe.MALE);
        }
        else
        newAgent.setSexe(Sexe.FEMALE);

        newAgent.setDate_debut_position(agent.getDate_debut_position()) ;
        newAgent.setDate_naissance(agent.getDate_naissance());
       Grade newGrade= gradeRepository.findByIdgrade(agent.getCode_grade());
        Residence newResidence=residenceRepository.findByIdresidence(agent.getCode_residence());
        Position newPotion =positionRepository.findByIdposition(agent.getCode_position());
       newAgent.setGrade( newGrade);
       newAgent.setPosition(newPotion);
       newAgent.setResidence(newResidence);
     newAgent.setSituation_familiale(SituationFamiliale.valueOf(agent.getSituation_familiale()));
     newAgent.setSituation_administrative(SituationAdmin.valueOf(agent.getSituation_administrative()));
      //System.out.println(newResidence);
             //   System.out.println(newPotion);
return newAgent;
    }

    public Agent updateAgent(Integer id_agent, Agent agentToUpdate) {
        Optional<Agent> existingAgentOptional = agentRepository.findById(id_agent);
        if (existingAgentOptional.isPresent()) {
            Agent existingAgent = existingAgentOptional.get();
            // Mettre à jour les champs de l'agent existant avec les nouvelles valeurs
            existingAgent.setMatricule_agent(agentToUpdate.getMatricule_agent());
            existingAgent.setNomprenom(agentToUpdate.getNomprenom());
            existingAgent.setSexe(agentToUpdate.getSexe());
            existingAgent.setPosition(agentToUpdate.getPosition());
            existingAgent.setResidence(agentToUpdate.getResidence());
            existingAgent.setSituation_administrative(agentToUpdate.getSituation_administrative());
            existingAgent.setSituation_familiale(agentToUpdate.getSituation_familiale());
            existingAgent.setDate_naissance(agentToUpdate.getDate_naissance());
            existingAgent.setDate_debut_position(agentToUpdate.getDate_debut_position());
            existingAgent.setDate_entree_en_activite(agentToUpdate.getDate_entree_en_activite());
            return agentRepository.save(existingAgent);
        } else {
            return null;
        }
    }

    public void deleteAgent(Integer id_agent) {
        agentRepository.deleteById(id_agent);
    }
}
