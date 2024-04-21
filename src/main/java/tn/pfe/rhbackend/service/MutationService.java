package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Mutation;
import tn.pfe.rhbackend.repository.MutationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MutationService {

    private final MutationRepository mutationRepository;

    @Autowired
    public MutationService(MutationRepository mutationRepository) {
        this.mutationRepository = mutationRepository;
    }

    public Mutation createMutation(Mutation mutation) {
        return mutationRepository.save(mutation);
    }

    public List<Mutation> getAllMutations() {
        return mutationRepository.findAll();
    }

    public Optional<Mutation> getMutationById(Integer id) {
        return mutationRepository.findById(id);
    }

    public Mutation updateMutation(Integer id, Mutation updatedMutation) {
        Optional<Mutation> existingMutationOptional = mutationRepository.findById(id);
        if (existingMutationOptional.isPresent()) {
            Mutation existingMutation = existingMutationOptional.get();
            //existingMutation.setResidence_muter(updatedMutation.getResidence_muter());

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

