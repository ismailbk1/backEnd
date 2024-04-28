package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Bureau;
import tn.pfe.rhbackend.service.BureauService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bureaux")
public class BureauController {

    @Autowired
    private BureauService bureauService;

    @GetMapping("/")
    public List<Bureau> getAllBureaux() {
        return bureauService.getAllBureaux();
    }

    @GetMapping("/{id}")
    public Optional<Bureau> getBureauById(@PathVariable Integer id) {
        return bureauService.getBureauById(id);
    }

    @PostMapping("/")
    public Bureau addBureau(@RequestBody Bureau bureau) {
        return bureauService.addBureau(bureau);
    }

    @PutMapping("/{id}")
    public Bureau updateBureau(@PathVariable Long id, @RequestBody Bureau bureau) {
        return bureauService.updateBureau(id, bureau);
    }

    @DeleteMapping("/{id}")
    public void deleteBureau(@PathVariable Integer id) {
        bureauService.deleteBureau(id);
    }
}

