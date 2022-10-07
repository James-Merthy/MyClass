package bxl.model.dto;


import bxl.model.entities.Local;
import bxl.model.entities.Lecon;
import bxl.model.entities.Prof;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProfDTO {

    private Long id;
    private String prenom;
    private String nom;
    private Long userId ;
    private String username ;


}
