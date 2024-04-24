package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Besoin;
import tn.pfe.rhbackend.service.BesoinService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BesoinController {

    @Autowired
    private BesoinService besoinService;

    @GetMapping("/getBesoins")
    public List<Besoin> getAllBesoins() {
        return besoinService.getAllBesoins();
    }

    @GetMapping("/getBesoinById/{id}")
    public Optional<Besoin> getBesoinById(@PathVariable Integer id) {
        return besoinService.getBesoinById(id);
    }

    @PostMapping("/addBesoin")
    public Besoin addBesoin(@RequestBody Besoin besoin) {
        return besoinService.addBesoin(besoin);
    }

    @PutMapping("/updateBesoin/{id}")
    public Besoin updateBesoin(@PathVariable Integer id, @RequestBody Besoin besoin) {
        return besoinService.updateBesoin(id, besoin);
    }

    @DeleteMapping("/deleteBesoin/{id}")
    public void deleteBesoin(@PathVariable Integer id) {
        besoinService.deleteBesoin(id);
    }
}

