package bxl.model.forms;

import lombok.Data;

@Data
public class UtilisateurUpdateForm {
    private String username;
    private String password;
    private boolean enabled;
}
