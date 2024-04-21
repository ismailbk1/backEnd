package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Bureau;
import tn.pfe.rhbackend.repository.BureauRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BureauService {

    @Autowired
    private BureauRepository bureauRepository;

    public List<Bureau> getAllBureaux() {
        return bureauRepository.findAll();
    }

    public Optional<Bureau> getBureauById(Integer id) {
        return bureauRepository.findById(id);
    }

    public Bureau addBureau(Bureau bureau) {
        return bureauRepository.save(bureau);
    }

    public Bureau updateBureau(Integer id, Bureau bureau) {
        if (bureauRepository.existsById(id)) {
            bureau.setIdbureau(id);
            return bureauRepository.save(bureau);
        } else {
            return null; // Gérer l'erreur
        }
    }

    public void deleteBureau(Integer id) {
        bureauRepository.deleteById(id);
    }
}

