package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Position;
import tn.pfe.rhbackend.service.PositionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/getPosition")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/position/{id}")
    public Optional<Position> getPositionById(@PathVariable Integer id) {
        return positionService.getPositionById(id);
    }

    @PostMapping("/addPosition")
    public Position addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @PutMapping("/updatePosition/{id}")
    public Position updatePosition(@PathVariable Integer id, @RequestBody Position position) {
        return positionService.updatePosition(id, position);
    }

    @DeleteMapping("/deletePosition/{id}")
    public void deletePosition(@PathVariable Integer id) {
        positionService.deletePosition(id);
    }
}
