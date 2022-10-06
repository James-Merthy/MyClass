package bxl.model.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UtilisateurLoginForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
