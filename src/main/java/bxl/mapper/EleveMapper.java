package bxl.mapper;

import bxl.model.dto.EleveDTO;
import bxl.model.entities.Eleve;
import org.springframework.stereotype.Component;

@Component
public class EleveMapper {

    private final LocalMapper localMapper;

    public EleveMapper(LocalMapper localMapper) {
        this.localMapper = localMapper;
    }

    public EleveDTO toDto (Eleve entity){

        if( entity == null )
            return null;

        return EleveDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .classe(entity.getClasse())
                .build();
    }

    public Eleve toEntity(Eleve form){

        if( form == null )
            throw new IllegalArgumentException();

        Eleve entity = new Eleve();

        entity.setPrenom(form.getPrenom());
        entity.setNom(form.getNom());
        entity.getClasse();

        return entity;

    }
}
