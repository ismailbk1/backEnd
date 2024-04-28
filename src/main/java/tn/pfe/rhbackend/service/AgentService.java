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

    public Optional<Agent> getAgentByMatricule(Long id_agent) {
        return agentRepository.findByMatriculeAgent(id_agent);
    }

    public Agent addAgent(AgentDto agent) {
         Agent newAgent=mapToAgent(agent);

        return agentRepository.save(newAgent);

    }

    private Agent mapToAgent(AgentDto agent) {
        Agent newAgent =new Agent();
 newAgent.setMatriculeAgent(Long.valueOf(agent.getMatricule_agent()));
        newAgent.setDate_entree_en_activite(agent.getDate_entree_en_activite());
        newAgent.setNomprenom(agent.getNomprenom());
     newAgent.setSexe(Sexe.valueOf(agent.getSexe()));
        newAgent.setDate_debut_position(agent.getDate_debut_position()) ;
        newAgent.setDate_naissance(agent.getDate_naissance());

       Optional<Grade> newGrade= gradeRepository.findByCodeGrade(agent.getCode_grade());
if(newGrade.isPresent())
    newAgent.setGrade( newGrade.get());
        Optional<Residence> newResidence= Optional.ofNullable(residenceRepository.findByCodeResidence(agent.getCode_residence()));
        if(newResidence.isPresent())
            newAgent.setResidence(newResidence.get());

        Optional<Position> newPotion =positionRepository.findByCodePosition(agent.getCode_position());
      if(newPotion.isPresent())
       newAgent.setPosition(newPotion.get());

     newAgent.setSituation_familiale(SituationFamiliale.valueOf(agent.getSituation_familiale()));
     newAgent.setSituation_administrative(SituationAdmin.valueOf(agent.getSituation_administrative()));
      //System.out.println(newResidence);
             //   System.out.println(newPotion);
return newAgent;
    }

    public Agent updateAgent(Integer id_agent, Agent agentToUpdate) {
        Optional<Agent> existingAgentOptional = agentRepository.findByMatriculeAgent(Long.valueOf(id_agent));
        if (existingAgentOptional.isPresent()) {
            Agent existingAgent = existingAgentOptional.get();
            // Mettre à jour les champs de l'agent existant avec les nouvelles valeurs
           // existingAgent.setMatriculeAgent(agentToUpdate.getMatriculeAgent());
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
