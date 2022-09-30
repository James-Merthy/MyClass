package bxl.repository;

import bxl.model.entities.Prof;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfRespository extends JpaRepository<Prof, Long> {
}
