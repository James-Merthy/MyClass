package bxl.model.forms;

import bxl.model.entities.Utilisateur;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UtilisateurCreeForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;


}
