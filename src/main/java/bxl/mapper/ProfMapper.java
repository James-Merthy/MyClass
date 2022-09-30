package bxl.mapper;

import bxl.model.dto.ProfDTO;
import bxl.model.entities.Eleve;
import bxl.model.entities.Prof;
import bxl.model.forms.ProfUpdateForm;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProfMapper {

    private final LocalMapper localMapper;

    public ProfMapper( LocalMapper localMapper) {
        this.localMapper = localMapper;
    }



    public ProfDTO toDto(Prof entity){

        if( entity == null )
            return null;

        Set<ProfDTO.LeconDTO> lecon = new HashSet<>();
        if( entity.getListLecon() != null )
            entity.getListLecon().stream()
                    .map( ProfDTO.LeconDTO::fromEntity )
                    .forEach(lecon::add);

        return ProfDTO.builder()
                .id( entity.getId() )
                .prenom( entity.getPrenom() )
                .nom( entity.getNom() )
                .classe(entity.getClasse())
                .lecons(lecon)
                .build();



    }

    public Prof toEntity(ProfUpdateForm form){

        if( form == null )
            throw new IllegalArgumentException();

        Prof entity = new Prof ();

        entity.setPrenom(form.getPrenom());
        entity.setNom(form.getNom());
        entity.getClasse();
        entity.getListLecon().add(form.getLecon());

        return entity;

    }
}
