package bxl.mapper;

import bxl.model.dto.LocalDTO;
import bxl.model.entities.Local;
import bxl.model.entities.Prof;
import bxl.model.forms.LocalInsertForm;
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

        return LocalDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .profId(entity.getId())
                .build();
    }

    public Local toEntity(LocalInsertForm form){

        if( form == null )
            throw new IllegalArgumentException();

        Local entity = new Local ();


        entity.setNom(form.getNom());



        return entity;

    }

}


