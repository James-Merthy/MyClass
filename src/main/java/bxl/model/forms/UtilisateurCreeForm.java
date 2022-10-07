package bxl.model.forms;

import bxl.model.entities.Utilisateur;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UtilisateurCreeForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;




}
