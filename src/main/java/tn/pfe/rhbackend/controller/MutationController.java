package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Mutation;
import tn.pfe.rhbackend.service.MutationService;

import java.util.List;

@RestController
@RequestMapping("/mutations")
public class MutationController {

    private final MutationService mutationService;

    @Autowired
    public MutationController(MutationService mutationService) {
        this.mutationService = mutationService;
    }

    @PostMapping
    public ResponseEntity<Mutation> createMutation(@RequestBody Mutation mutation) {
        Mutation createdMutation = mutationService.createMutation(mutation);
        return new ResponseEntity<>(createdMutation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Mutation>> getAllMutations() {
        List<Mutation> mutations = mutationService.getAllMutations();
        return new ResponseEntity<>(mutations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mutation> getMutationById(@PathVariable Integer id) {
        return mutationService.getMutationById(id)
                .map(mutation -> new ResponseEntity<>(mutation, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mutation> updateMutation(@PathVariable Integer id, @RequestBody Mutation updatedMutation) {
        Mutation mutation = mutationService.updateMutation(id, updatedMutation);
        if (mutation != null) {
            return new ResponseEntity<>(mutation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMutation(@PathVariable Integer id) {
        mutationService.deleteMutation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

