package bxl.model.forms;

import bxl.model.entities.Prof;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LocalInsertForm {

    @NotBlank
    @Size(max = 255)
    private String nom;


}
