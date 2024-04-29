package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Residence;
import tn.pfe.rhbackend.service.ResidenceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ResidenceController {

    @Autowired
    private ResidenceService residenceService;

    @GetMapping("/getResidence")
    public List<Residence> getAllResidences() {
        return residenceService.getAllResidences();
    }

    @GetMapping("/getResidenceById/{id_residence}")
    public Optional<Residence> getResidenceByCode(@PathVariable Integer id_residence) {
        return residenceService.getResidenceByCode(id_residence);
    }

    @PostMapping("/addResidence")
    public Residence addResidence(@RequestBody Residence residence) {
        return residenceService.addResidence(residence);
    }

    @PutMapping("/updateResidence/{id_residence}")
    public Residence updateResidence(@PathVariable Integer id_residence, @RequestBody Residence residence) {
        return residenceService.updateResidence(id_residence , residence);
    }

    @DeleteMapping("/deleteResidence/{id_residence}")
    public void deleteResidence(@PathVariable Integer id_residence) {
        residenceService.deleteResidence(id_residence);
    }
}

