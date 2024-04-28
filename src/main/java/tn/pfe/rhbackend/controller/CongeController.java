package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.dto.*;
import tn.pfe.rhbackend.model.Conge;
import tn.pfe.rhbackend.service.CongeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conges")
public class CongeController {
    @Autowired
    private CongeService congeService;

    @GetMapping
    public List<Conge> getAllConges() {
        return congeService.getAllConges();
    }

    @GetMapping("/{id}")
    public Conge getCongeById(@PathVariable Integer id) {
        return congeService.getCongeById(id);
    }

    @PostMapping
    public Conge addConge(@RequestBody CongeDto conge) {
        return congeService.addConge(conge);
    }

    @PutMapping("/{id}")
    public Conge updateConge(@PathVariable Integer id, @RequestBody CongeDto updatedConge) {
        return congeService.updateConge(id, updatedConge);
    }
    @DeleteMapping("/{id}")
    public void updateConge(@PathVariable Integer id) {
         congeService.deleteConge(id);
    }
}

