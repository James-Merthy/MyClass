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



//
//    @Data
//    @Builder
//    public static class EleveDTO {
//
//        private Long id;
//        private String nom;
//        private String prenom;
////        private Local classe ;
//
//
//        public static EleveDTO fromEntity (Eleve entity){
//
//            if (entity == null)
//                return null ;
//
//            return EleveDTO.builder()
//                    .id(entity.getId())
//                    .nom(entity.getNom())
//                    .prenom(entity.getPrenom())
//
//
//                    .build();
//        }
//
//
//    }


}
