package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.dto.CongeDto;
import tn.pfe.rhbackend.model.Conge;
import tn.pfe.rhbackend.repository.AgentRepository;
import tn.pfe.rhbackend.repository.CongeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CongeService {
    @Autowired
    private CongeRepository congeRepository;
    @Autowired
    private AgentRepository agentRepository;

    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    public Optional<Conge> getCongeById(Integer id) {
        return congeRepository.findByCodeConge(id);
    }

    public Conge addConge(CongeDto congeDto) {

        Conge conge=new Conge();
        conge.setCode_conge(congeDto.getCode_conge());
        conge.setType(congeDto.getType());
        conge.setDate_debut(congeDto.getDate_debut());
        conge.setNb_jour(congeDto.getNb_jour());
        conge.setDate_fin(congeDto.getDate_fin());
        conge.setAgent(agentRepository.findById(congeDto.getAgent()).get());

        return congeRepository.save(conge);
    }

    public Conge updateConge(Integer id, Conge updatedConge) {
        Optional<Conge> congeOptional = congeRepository.findByCodeConge(id);
        if (congeOptional.isPresent()) {
            Conge existingConge = congeOptional.get();
            // Mettez à jour les champs nécessaires

            existingConge.setDate_debut(updatedConge.getDate_debut());
            existingConge.setDate_fin(updatedConge.getDate_fin());
            existingConge.setNb_jour(updatedConge.getNb_jour());
            existingConge.setType(updatedConge.getType());
            return congeRepository.save(existingConge);
        } else {
            // Gérer le cas où le congé avec l'ID donné n'existe pas
            return null;
        }
    }

    public void deleteConge(Integer id) {
        congeRepository.deleteById(id);
    }
}

