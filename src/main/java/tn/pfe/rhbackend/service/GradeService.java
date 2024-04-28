package tn.pfe.rhbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.rhbackend.model.Grade;
import tn.pfe.rhbackend.repository.GradeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Integer id) {
        return gradeRepository.findByCodeGrade(id);
    }


    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Integer id, Grade grade) {
        if (gradeRepository.existsByCodeGrade(id)) {
            grade.setCodeGrade(id);
            return gradeRepository.save(grade);
        } else {
            return null; // Handle error
        }
    }

    public void deleteGrade(Integer id) {
        gradeRepository.deleteById(id);
    }
}
