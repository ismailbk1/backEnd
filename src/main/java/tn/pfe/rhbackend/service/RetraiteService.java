package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Retraite;
import tn.pfe.rhbackend.repository.RetraiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RetraiteService {

    private final RetraiteRepository retraiteRepository;

    @Autowired
    public RetraiteService(RetraiteRepository retraiteRepository) {
        this.retraiteRepository = retraiteRepository;
    }

    // Create
    public Retraite createRetraite(Retraite retraite) {
        return retraiteRepository.save(retraite);
    }

    // Read
    public Retraite getRetraiteById(Integer id) {
        Optional<Retraite> retraiteOptional = retraiteRepository.findById(id);
        return retraiteOptional.orElse(null);
    }

    public List<Retraite> getAllRetraites() {
        return retraiteRepository.findAll();
    }

    // Update
    public Retraite updateRetraite(Integer id, Retraite updatedRetraite) {
        Optional<Retraite> existingRetraiteOptional = retraiteRepository.findById(id);
        if (existingRetraiteOptional.isPresent()) {
            Retraite existingRetraite = existingRetraiteOptional.get();
            //existingRetraite.settype_retraite(updatedRetraite.gettype_retraite());
            // Mettez à jour d'autres attributs selon vos besoins
            return retraiteRepository.save(existingRetraite);
        } else {
            return null; // Gérer le cas où la retraite avec cet ID n'est pas trouvée
        }
    }

    // Delete
    public void deleteRetraite(Integer id) {
        retraiteRepository.deleteById(id);
    }
}

