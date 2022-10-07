package bxl.mapper;

import bxl.model.dto.EleveDTO;
import bxl.model.entities.Eleve;
import bxl.model.forms.EleveForm;
import bxl.repository.UtilisateurRespository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EleveMapper {

    private final UtilisateurRespository utilisateurRespository ;
    private final LocalMapper localMapper;

    public EleveMapper(UtilisateurRespository utilisateurRespository, LocalMapper localMapper) {
        this.utilisateurRespository = utilisateurRespository;

        this.localMapper = localMapper;
    }

    public EleveDTO toDto (Eleve entity){

        if( entity == null )
            return null;

        return EleveDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .userId(entity.getUtilisateur().getId())
                .localID(entity.getId())
                .username(entity.getUtilisateur().getUsername())
                .build();
    }

    public Eleve toEntity(EleveForm form){

        if( form == null )
            throw new IllegalArgumentException();

        Eleve entity = new Eleve();

        entity.setPrenom(form.getPrenom());
        entity.setNom(form.getNom());
        entity.setClasse(form.getClasse());
        entity.setUtilisateur(utilisateurRespository.findByUsername(form.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username not found.")));

        return entity;

    }
}
