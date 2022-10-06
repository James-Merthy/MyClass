package bxl.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UtilisateurDTO {

    private Long id;
    private String username;
    private List<String> roles;
    private boolean enabled;

}
