package bxl.model.forms;

import bxl.model.entities.Local;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class EleveForm {


    @NotBlank
    @Size(max = 255)
    private String nom;
    @NotBlank
    @Size(max = 255)
    private String prenom;
    @NotNull
    private Long localId    ;
    private Long userId ;
    private String username ;

}
