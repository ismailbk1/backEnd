package tn.pfe.rhbackend.service;

import jakarta.transaction.Transactional;
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
        return positionRepository.findByCodePosition(id);
    }

    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Integer id, Position position) {
        if (positionRepository.existsByCodePosition(id)) {
            position.setCodePosition(id);
            return positionRepository.save(position);
        } else {
            return null; // Handle error
        }
    }
    @Transactional

    public void deletePosition(Integer id) {

        positionRepository.deleteByCodePosition(id);
    }
}
