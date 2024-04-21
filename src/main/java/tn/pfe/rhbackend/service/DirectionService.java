package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Direction;
import tn.pfe.rhbackend.repository.DirectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionService {

    @Autowired
    private DirectionRepository directionRepository;

    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }

    public Optional<Direction> getDirectionById(Integer id) {
        return directionRepository.findById(id);
    }

    public Direction addDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    public Direction updateDirection(Integer id, Direction direction) {
        if (directionRepository.existsById(id)) {
            direction.setCode_direction(id);
            return directionRepository.save(direction);
        } else {
            return null; // Handle error
        }
    }

    public void deleteDirection(Integer id) {
        directionRepository.deleteById(id);
    }
}
