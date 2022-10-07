package bxl.mapper;

import bxl.model.dto.UtilisateurDTO;
import bxl.model.entities.Utilisateur;
import bxl.model.forms.UtilisateurCreeEleveForm;
import bxl.model.forms.UtilisateurCreeForm;
import bxl.model.forms.UtilisateurUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {
    public UtilisateurDTO toDto(Utilisateur entity) {
        if (entity == null)
            return null;
        return UtilisateurDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .enabled(entity.isEnabled())
                .roles(entity.getRoles())
                .build();
    }

    public Utilisateur toEntity(UtilisateurCreeForm form) {
        Utilisateur user = new Utilisateur();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setRoles(form.getRoles());
        return user;
    }

    public Utilisateur toEntity(UtilisateurCreeEleveForm form) {
        Utilisateur user = new Utilisateur();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setRoles(form.getRoles());
        return user;
    }

    public Utilisateur toEntity(UtilisateurCreeProfForm form) {
        Utilisateur user = new Utilisateur();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setRoles(form.getRoles());
        return user;
    }

    public Utilisateur toEntity(UtilisateurUpdateForm form) {
        Utilisateur user = new Utilisateur();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setEnabled(form.isEnabled());

        return user;
    }


}
