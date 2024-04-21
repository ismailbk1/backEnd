package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Residence;
import tn.pfe.rhbackend.repository.ResidenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenceService {

    @Autowired
    private ResidenceRepository residenceRepository;

    public List<Residence> getAllResidences() {
        return residenceRepository.findAll();
    }

    public Optional<Residence> getResidenceByCode(Integer id) {
        return residenceRepository.findById(id);
    }

    public Residence addResidence(Residence residence) {
        return residenceRepository.save(residence);
    }

    public Residence updateResidence(Integer id, Residence residence) {
        if (residenceRepository.existsById(id)) {
            residence.setCode_residence(id);
            return residenceRepository.save(residence);
        } else {
            return null; // Handle error
        }
    }

    public void deleteResidence(Integer code) {
        residenceRepository.deleteById(code);
    }
}

