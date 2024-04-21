package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Demande;
import tn.pfe.rhbackend.service.DemandeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @GetMapping("/")
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @GetMapping("/{id}")
    public Optional<Demande> getDemandeById(@PathVariable Integer id) {
        return demandeService.getDemandeById(id);
    }

    @PostMapping("/")
    public Demande addDemande(@RequestBody Demande demande) {
        return demandeService.addDemande(demande);
    }

    @PutMapping("/{id}")
    public Demande updateDemande(@PathVariable Integer id, @RequestBody Demande demande) {
        return demandeService.updateDemande(id, demande);
    }

    @DeleteMapping("/{id}")
    public void deleteDemande(@PathVariable Integer id) {
        demandeService.deleteDemande(id);
    }
}
