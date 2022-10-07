package bxl.model.dto;

import bxl.model.entities.Local;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class EleveDTO {

    private Long id;
    private String nom;
    private String prenom;
    private Long userId ;
    private String username ;

}
