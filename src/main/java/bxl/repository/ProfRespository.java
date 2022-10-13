package bxl.repository;

import bxl.model.entities.Prof;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfRespository extends JpaRepository<Prof, Long> {

    Optional<Prof> findByUtilisateur_Username(String username);

}
