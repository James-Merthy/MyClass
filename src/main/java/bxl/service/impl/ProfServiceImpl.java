package bxl.service.impl;

import bxl.exceptions.ElementNotFoundException;
import bxl.exceptions.UserNotTheSameException;
import bxl.mapper.ProfMapper;
import bxl.model.dto.ProfDTO;
import bxl.model.entities.Eleve;
import bxl.model.entities.Prof;
import bxl.model.forms.ProfInsertForm;
import bxl.model.forms.ProfUpdateForm;
import bxl.repository.ProfRespository;
import bxl.service.ProfService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfServiceImpl implements ProfService {

    private final ProfRespository profRespository ;

    private final ProfMapper profMapper ;

    public ProfServiceImpl(ProfRespository profRespository, ProfMapper profMapper) {
        this.profRespository = profRespository;
        this.profMapper = profMapper;
    }

    @Override
    public ProfDTO create(ProfInsertForm toInsert) {
        Prof prof = profMapper.toEntity((toInsert));
        return profMapper.toDto(profRespository.save(prof));
    }
    @Override
    public ProfDTO update(Long id, ProfUpdateForm toUpdate) {
        Prof prof  = profRespository.findById(id).
                orElseThrow(() -> new ElementNotFoundException(Prof.class , id ));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(e -> e.getAuthority().equals("ROLE_ADMIN"));
        boolean isOwner = prof.getUtilisateur().getUsername().equals(authentication.getName());

        if (!isAdmin && !isOwner)
            throw new UserNotTheSameException(prof.getUtilisateur().getUsername(), authentication.getName());

        if (toUpdate.getNom() != null)
            prof.setNom(toUpdate.getNom());
        if (toUpdate.getPrenom() != null)
            prof.setPrenom(toUpdate.getPrenom());
        return profMapper.toDto((prof));
    }

    @Override
    public ProfDTO getOne(Long id) {

        return profRespository.findById(id)
                .map(profMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Prof.class, id));
    }

    @Override
    public List<ProfDTO> getAll() {
        return profRespository.findAll().stream()
                .map(profMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfDTO delete(Long id) {
        Prof toDelete = profRespository.findById(id)
//                .map(eleveMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Prof.class, id));

        profRespository.delete(toDelete);
        return profMapper.toDto( toDelete );
    }


}
