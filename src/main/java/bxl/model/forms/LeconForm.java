package bxl.model.forms;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class LeconForm {

    @NotBlank
    @Size(max = 255)
    private String nom;
}
