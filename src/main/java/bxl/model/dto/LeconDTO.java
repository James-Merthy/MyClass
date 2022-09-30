package bxl.model.dto;

import bxl.model.entities.Local;
import bxl.model.entities.Prof;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeconDTO {

    private Long id;
    private String nom;
    private Prof prof ;
    private Local classe;

}
