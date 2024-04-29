package tn.pfe.rhbackend.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Residence;
import tn.pfe.rhbackend.repository.DirectionRepository;
import tn.pfe.rhbackend.repository.ResidenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenceService {

    @Autowired
    private ResidenceRepository residenceRepository;
    @Autowired
    private DirectionRepository directionRepository;

    public List<Residence> getAllResidences() {
        return residenceRepository.findAll();
    }

    public Optional<Residence> getResidenceByCode(Integer id) {
        return Optional.ofNullable(residenceRepository.findByCodeResidence(id));
    }

    public Residence addResidence(Residence residence) {

        return residenceRepository.save(residence);
    }

    public Residence updateResidence(Integer id, Residence residence) {
        if (residenceRepository.existsByCodeResidence(id)) {
            residence.setCodeResidence(id);
            return residenceRepository.save(residence);
        } else {
            return null; // Handle error
        }
    }

    @Transactional
    public void deleteResidence(Integer code) {
        residenceRepository.deleteByCodeResidence(code);
    }
}

