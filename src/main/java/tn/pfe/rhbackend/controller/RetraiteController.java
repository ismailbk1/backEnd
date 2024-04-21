package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Retraite;
import tn.pfe.rhbackend.service.RetraiteService;

import java.util.List;

@RestController
@RequestMapping("/retraites")
public class RetraiteController {

    private final RetraiteService retraiteService;

    @Autowired
    public RetraiteController(RetraiteService retraiteService) {
        this.retraiteService = retraiteService;
    }

    // Endpoint pour créer une retraite
    @PostMapping
    public ResponseEntity<Retraite> createRetraite(@RequestBody Retraite retraite) {
        Retraite createdRetraite = retraiteService.createRetraite(retraite);
        return new ResponseEntity<>(createdRetraite, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer toutes les retraites
    @GetMapping
    public ResponseEntity<List<Retraite>> getAllRetraites() {
        List<Retraite> retraites = retraiteService.getAllRetraites();
        return new ResponseEntity<>(retraites, HttpStatus.OK);
    }

    // Endpoint pour récupérer une retraite par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Retraite> getRetraiteById(@PathVariable("id") Integer id) {
        Retraite retraite = retraiteService.getRetraiteById(id);
        if (retraite != null) {
            return new ResponseEntity<>(retraite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour mettre à jour une retraite
    @PutMapping("/{id}")
    public ResponseEntity<Retraite> updateRetraite(@PathVariable("id") Integer id, @RequestBody Retraite updatedRetraite) {
        Retraite retraite = retraiteService.updateRetraite(id, updatedRetraite);
        if (retraite != null) {
            return new ResponseEntity<>(retraite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer une retraite
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetraite(@PathVariable("id") Integer id) {
        retraiteService.deleteRetraite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
