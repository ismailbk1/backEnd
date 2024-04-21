package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Conge;
import tn.pfe.rhbackend.repository.CongeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CongeService {
    @Autowired
    private CongeRepository congeRepository;

    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    public Optional<Conge> getCongeById(Integer id) {
        return congeRepository.findById(id);
    }

    public Conge addConge(Conge conge) {
        return congeRepository.save(conge);
    }

    public Conge updateConge(Integer id, Conge updatedConge) {
        Optional<Conge> congeOptional = congeRepository.findById(id);
        if (congeOptional.isPresent()) {
            Conge existingConge = congeOptional.get();
            // Mettez à jour les champs nécessaires
            existingConge.setCode_conge(updatedConge.getCode_conge());
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
}

