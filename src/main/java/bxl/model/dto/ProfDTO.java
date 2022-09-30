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
    private Local classe ;
    private Set<ProfDTO.LeconDTO> lecons ;

    @Data
    @Builder

    public static class LeconDTO {

        private Long id;
        private String nom;
        private Prof prof;
        private Local classe;

        public static LeconDTO fromEntity(Lecon entity) {

            if (entity == null)
                return null;

            return  LeconDTO.builder()
                    .id(entity.getId())
                    .nom(entity.getNom())
                    .prof(entity.getProf())
                    .classe(entity.getClasse())
                    .build();

        }

    }
}
