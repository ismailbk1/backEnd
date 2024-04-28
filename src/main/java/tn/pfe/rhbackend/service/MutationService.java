package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.dto.MutationDto;
import tn.pfe.rhbackend.model.Mutation;
import tn.pfe.rhbackend.model.Retraite;
import tn.pfe.rhbackend.repository.AgentRepository;
import tn.pfe.rhbackend.repository.MutationRepository;
import tn.pfe.rhbackend.repository.ResidenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MutationService {

    private final MutationRepository mutationRepository;
    private final AgentRepository agentRepository;
    private final ResidenceRepository residenceRepository;

    @Autowired
    public MutationService(MutationRepository mutationRepository, AgentRepository agentRepository, ResidenceRepository residenceRepository) {
        this.mutationRepository = mutationRepository;
        this.agentRepository = agentRepository;
        this.residenceRepository = residenceRepository;
    }

    public Mutation createMutation(MutationDto mutationDto) {

        Mutation mutation=new Mutation();
        mutation.setAgent(agentRepository.findById(mutationDto.getAgent()).get());
        mutation.setResidence(residenceRepository.findByCodeResidence(mutationDto.getCodeResidenceactuel()));
       mutation.setResidence_muter(residenceRepository.findByCodeResidence(mutationDto.getCodeResidencemuter()).getLibelle());
        mutation.setDate_depart_persivible(mutationDto.getDateDepartPreversible());
        mutation.setDate_demande(mutationDto.getDateDemande());
        mutation.setMotif_depart(mutationDto.getMotif());
        return mutationRepository.save(mutation);
    }

    public List<Mutation> getAllMutations() {
        return mutationRepository.findAll();
    }

    public Optional<Mutation> getMutationById(Integer id) {
        return mutationRepository.findById(id);
    }

    public Mutation updateMutation(Integer id, MutationDto updatedMutation) {
        Optional<Mutation> existingMutationOptional = mutationRepository.findById(id);
        if (existingMutationOptional.isPresent()) {
            Mutation existingMutation = existingMutationOptional.get();
            //existingMutation.setResidence_muter(updatedMutation.getResidence_muter());
            existingMutation.setAgent(agentRepository.findById(updatedMutation.getAgent()).get());
            existingMutation.setResidence(residenceRepository.findByCodeResidence(updatedMutation.getCodeResidenceactuel()));
            existingMutation.setResidence_muter(residenceRepository.findByCodeResidence(updatedMutation.getCodeResidencemuter()).getLibelle());
            existingMutation.setDate_depart_persivible(updatedMutation.getDateDepartPreversible());
            existingMutation.setDate_demande(updatedMutation.getDateDemande());
            existingMutation.setMotif_depart(updatedMutation.getMotif());
            // Mettez à jour d'autres champs selon vos besoins
            return mutationRepository.save(existingMutation);
        } else {
            return null;
        }
    }

    public void deleteMutation(Integer id) {
        mutationRepository.deleteById(id);
    }
}

