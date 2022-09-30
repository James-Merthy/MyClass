package bxl.repository;

import bxl.model.entities.Eleve;
import bxl.model.entities.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeconRespository extends JpaRepository<Lecon,Long> {


}
