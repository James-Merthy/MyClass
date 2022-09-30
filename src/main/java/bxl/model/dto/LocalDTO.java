package bxl.model.dto;

import bxl.model.entities.Local;
import bxl.model.entities.Eleve;
import bxl.model.entities.Lecon;
import bxl.model.entities.Prof;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class LocalDTO {

    private Long id;
    private String nom;
    private Prof professeur ;
    private Set<LocalDTO.EleveDTO> nombreEleve ;
    private Set<LocalDTO.LeconDTO> listLecon ;

    @Data
    @Builder
    public static class EleveDTO {

        private Long id;
        private String nom;
        private String prenom;
        private Local classe ;


        public static EleveDTO fromEntity (Eleve entity){

            if (entity == null)
                return null ;

            return EleveDTO.builder()
                    .id(entity.getId())
                    .nom(entity.getNom())
                    .prenom(entity.getPrenom())
                    .classe(entity.getClasse())

                    .build();
        }


    }

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

            return LeconDTO.builder()
                    .id(entity.getId())
                    .nom(entity.getNom())
                    .prof(entity.getProf())
                    .classe(entity.getClasse())
                    .build();

        }

    }
}
