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
    private Set<String> lecons ;
    private Long userId ;
    private String username ;

    @Data
    @Builder

    public static class LeconDTO {
        private String nom;

        public static LeconDTO fromEntity(Lecon entity) {

            if (entity == null)
                return null;

            return  LeconDTO.builder()
                    .nom(entity.getNom())
                    .build();

        }

    }
}
