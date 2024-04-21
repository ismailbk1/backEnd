package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Direction;
import tn.pfe.rhbackend.service.DirectionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directions")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @GetMapping("/")
    public List<Direction> getAllDirections() {
        return directionService.getAllDirections();
    }

    @GetMapping("/{id}")
    public Optional<Direction> getDirectionById(@PathVariable Integer id) {
        return directionService.getDirectionById(id);
    }

    @PostMapping("/")
    public Direction addDirection(@RequestBody Direction direction) {
        return directionService.addDirection(direction);
    }

    @PutMapping("/{id}")
    public Direction updateDirection(@PathVariable Integer id, @RequestBody Direction direction) {
        return directionService.updateDirection(id, direction);
    }

    @DeleteMapping("/{id}")
    public void deleteDirection(@PathVariable Integer id) {
        directionService.deleteDirection(id);
    }
}