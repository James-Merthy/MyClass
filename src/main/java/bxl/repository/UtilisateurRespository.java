package bxl.repository;

import bxl.model.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRespository extends CrudRepository <Utilisateur , Long> {

    Optional<Utilisateur> findByUsername(String username);
}
