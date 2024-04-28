package tn.pfe.rhbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.dto.RetraiteDto;
import tn.pfe.rhbackend.model.Retraite;
import tn.pfe.rhbackend.repository.AgentRepository;
import tn.pfe.rhbackend.repository.ResidenceRepository;
import tn.pfe.rhbackend.repository.RetraiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RetraiteService {

    private final RetraiteRepository retraiteRepository;
    private final AgentRepository agentRepository;
    private final ResidenceRepository residenceRepository;


    @Autowired
    public RetraiteService(RetraiteRepository retraiteRepository, AgentRepository agentRepository, ResidenceRepository residenceRepository) {
        this.retraiteRepository = retraiteRepository;
        this.agentRepository = agentRepository;
        this.residenceRepository = residenceRepository;
    }

    // Create
    public Retraite createRetraite(RetraiteDto retraiteDto) {
        Retraite retraite=new Retraite();
        retraite.setAgent(agentRepository.findById(retraiteDto.getAgent()).get());
        retraite.setResidence(residenceRepository.findByCodeResidence(retraiteDto.getCodeResidence()));
        retraite.setStatus(retraiteDto.getStatus());
        retraite.setType_retraite(retraiteDto.getTypeRetraite());
        retraite.setDate_depart_persivible(retraiteDto.getDateDepartPreversible());
        retraite.setDate_demande(retraiteDto.getDateDemande());
        retraite.setMotif_depart(retraiteDto.getMotif());




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

