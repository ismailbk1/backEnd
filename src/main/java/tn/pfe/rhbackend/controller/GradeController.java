package tn.pfe.rhbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.rhbackend.model.Grade;
import tn.pfe.rhbackend.service.GradeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api") // http:\\localhost:8080/grades
public class GradeController {

    @Autowired //pour injection dépendance
    private GradeService gradeService;

    @GetMapping("/getGrades")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}") //juste grade selon code
    public Optional<Grade> getGradeById(@PathVariable Integer id) {
        return gradeService.getGradeById(id);
    }

    @PostMapping("/")
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Integer id, @RequestBody Grade grade) {
        return gradeService.updateGrade(id, grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Integer id) {
        gradeService.deleteGrade(id);
    }
}
