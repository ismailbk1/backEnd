package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Besoin;
import tn.pfe.rhbackend.repository.BesoinRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BesoinService {

    @Autowired
    private BesoinRepository besoinRepository;

    public List<Besoin> getAllBesoins() {
        return besoinRepository.findAll();
    }

    public Optional<Besoin> getBesoinById(Integer id) {
        return besoinRepository.findById(id);
    }

    public Besoin addBesoin(Besoin besoin) {
        return besoinRepository.save(besoin);
    }

    public Besoin updateBesoin(Integer id, Besoin besoin) {
        if (besoinRepository.existsById(id)) {
            besoin.setIdbesoin(id);
            return besoinRepository.save(besoin);
        } else {
            return null; // Handle error
        }
    }

    public void deleteBesoin(Integer id) {
        besoinRepository.deleteById(id);
    }
}
