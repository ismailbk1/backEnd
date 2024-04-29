package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Direction;
import tn.pfe.rhbackend.service.DirectionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @GetMapping("/getDirection")
    public List<Direction> getAllDirections() {
        return directionService.getAllDirections();
    }

    @GetMapping("/getDirectionById/{id}")
    public Optional<Direction> getDirectionById(@PathVariable Integer id) {
        return directionService.getDirectionById(id);
    }

    @PostMapping("/addDirection")
    public Direction addDirection(@RequestBody Direction direction) {
        return directionService.addDirection(direction);
    }

    @PutMapping("/updateDirection/{id}")
    public Direction updateDirection(@PathVariable Integer id, @RequestBody Direction direction) {
        return directionService.updateDirection(id, direction);
    }

    @DeleteMapping("/deleteDirection/{id}")
    public void deleteDirection(@PathVariable Integer id) {
        directionService.deleteDirection(id);
    }
}