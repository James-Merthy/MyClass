package bxl.mapper;

import bxl.model.dto.LeconDTO;
import bxl.model.dto.ProfDTO;
import bxl.model.entities.Eleve;
import bxl.model.entities.Lecon;
import bxl.model.forms.LeconForm;
import org.springframework.stereotype.Component;

@Component
public class LeconMapper {

    private final ProfMapper profMapper ;

    public LeconMapper(ProfMapper profMapper) {
        this.profMapper = profMapper;
    }

    public LeconDTO toDto (Lecon entity){

        if( entity == null )
            return null;

        return LeconDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prof(entity.getProf())
                .build();
    }

    public Lecon toEntity(LeconForm form){

        if( form == null )
            throw new IllegalArgumentException();

        Lecon entity = new Lecon();

        entity.setNom(form.getNom());


        return entity;

    }
}
