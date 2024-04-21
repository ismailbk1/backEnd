package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Position;
import tn.pfe.rhbackend.repository.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Optional<Position> getPositionById(Integer id) {
        return positionRepository.findById(id);
    }

    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Integer id, Position position) {
        if (positionRepository.existsById(id)) {
            position.setCode_position(id);
            return positionRepository.save(position);
        } else {
            return null; // Handle error
        }
    }

    public void deletePosition(Integer id) {
        positionRepository.deleteById(id);
    }
}
