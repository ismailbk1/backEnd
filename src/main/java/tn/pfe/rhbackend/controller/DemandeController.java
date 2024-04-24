package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Demande;
import tn.pfe.rhbackend.service.DemandeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @GetMapping("/getDemandes")
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @GetMapping("/getDemandeById/{id}")
    public Optional<Demande> getDemandeById(@PathVariable Integer id) {
        return demandeService.getDemandeById(id);
    }

    @PostMapping("/addDemande")
    public Demande addDemande(@RequestBody Demande demande) {
        return demandeService.addDemande(demande);
    }

    @PutMapping("/updateDemande/{id}")
    public Demande updateDemande(@PathVariable Integer id, @RequestBody Demande demande) {
        return demandeService.updateDemande(id, demande);
    }

    @DeleteMapping("/deleteDemande/{id}")
    public void deleteDemande(@PathVariable Integer id) {
        demandeService.deleteDemande(id);
    }
}
