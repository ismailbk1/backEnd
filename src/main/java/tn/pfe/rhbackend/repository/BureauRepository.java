package tn.pfe.rhbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pfe.rhbackend.model.Bureau;

import java.util.Optional;

public interface BureauRepository extends JpaRepository<Bureau, Long> {
    boolean existsByCodeBureau(Long id);

    Optional<Bureau> findByCodeBureau(Integer id);

    void deleteByCodeBureau(Integer id);
}

