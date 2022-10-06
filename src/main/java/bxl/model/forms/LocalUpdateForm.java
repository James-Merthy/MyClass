package bxl.model.forms;

import bxl.model.entities.Lecon;
import bxl.model.entities.Local;
import bxl.model.entities.Prof;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class LocalUpdateForm {

    @NotBlank
    @Size(max = 255)
    private String nom;

    @NotNull
    private Prof professeur;


}
