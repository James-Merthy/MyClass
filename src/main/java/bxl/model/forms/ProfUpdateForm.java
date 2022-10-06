package bxl.model.forms;

import bxl.model.entities.Lecon;
import bxl.model.entities.Local;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProfUpdateForm {
    @NotBlank
    @Size(max = 255)
    private String nom;
    @NotBlank
    @Size(max = 255)
    private String prenom;
    @NotNull
    private Local classe ;
    @NotNull
    private Lecon lecon;
    private String username ;

}


