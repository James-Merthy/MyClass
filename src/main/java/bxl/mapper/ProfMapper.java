package bxl.mapper;

import bxl.model.dto.ProfDTO;
import bxl.model.entities.Prof;
import bxl.model.forms.ProfInsertForm;
import bxl.repository.UtilisateurRespository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProfMapper {

    private final UtilisateurRespository utilisateurRespository ;



    public ProfMapper(UtilisateurRespository utilisateurRespository) {
        this.utilisateurRespository = utilisateurRespository;

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
                .userId(entity.getUtilisateur().getId())
                .username(entity.getUtilisateur().getUsername())
                .build();



    }


    public Prof toEntity(ProfInsertForm form){

        if( form == null )
            throw new IllegalArgumentException();

        Prof entity = new Prof ();

        entity.setPrenom(form.getPrenom());
        entity.setNom(form.getNom());
        entity.setClasse(form.getClasse());
        entity.getListLecon();
        entity.setUtilisateur(utilisateurRespository.findByUsername(form.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username not found.")));


        return entity;

    }

}