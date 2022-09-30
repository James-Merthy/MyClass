package bxl.mapper;

import bxl.model.dto.LocalDTO;
import bxl.model.entities.Local;
import bxl.model.entities.Prof;
import bxl.model.forms.LocalUpdateForm;
import bxl.model.forms.ProfUpdateForm;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LocalMapper {

    public LocalDTO toDto(Local entity){

        if(entity == null)
            return null;

        Set<LocalDTO.EleveDTO> eleve = new HashSet<>();
        if( entity.getNombreEleve() != null )
            entity.getNombreEleve().stream()
                    .map( LocalDTO.EleveDTO::fromEntity )
                    .forEach(eleve::add);

        Set<LocalDTO.LeconDTO> lecon = new HashSet<>();
        if( entity.getListLecon() != null )
            entity.getListLecon().stream()
                    .map( LocalDTO.LeconDTO::fromEntity )
                    .forEach(lecon::add);

        return LocalDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .nombreEleve(eleve)
                .professeur(entity.getProfesseur())
                .listLecon(lecon)
                .build();
    }

    public Local toEntity(LocalUpdateForm form){

        if( form == null )
            throw new IllegalArgumentException();

        Local entity = new Local ();


        entity.setNom(form.getNom());
        entity.getListLecon();
        entity.getListLecon().add(form.getLecon());

        return entity;

    }

}


