package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Demande;
import tn.pfe.rhbackend.repository.DemandeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> getDemandeById(Integer id) {
        return demandeRepository.findById(id);
    }

    public Demande addDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    public Demande updateDemande(Integer id, Demande demande) {
        if (demandeRepository.existsById(id)) {
            demande.setIddemande(id);
            return demandeRepository.save(demande);
        } else {
            return null; // Handle error
        }
    }

    public void deleteDemande(Integer id) {
        demandeRepository.deleteById(id);
    }
}

