package bxl.service.impl;

import bxl.exceptions.ElementNotFoundException;
import bxl.exceptions.UserNotTheSameException;
import bxl.mapper.EleveMapper;
import bxl.model.dto.EleveDTO;
import bxl.model.entities.Eleve;
import bxl.model.entities.Prof;
import bxl.model.forms.EleveForm;
import bxl.repository.EleveRespository;
import bxl.service.EleveService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EleveServiceImpl implements EleveService {

    private final EleveRespository eleveRespository ;

    private final EleveMapper eleveMapper ;

    public EleveServiceImpl(EleveRespository eleveRespository, EleveMapper eleveMapper) {
        this.eleveRespository = eleveRespository;
        this.eleveMapper = eleveMapper;
    }


    @Override
    public EleveDTO create(EleveForm toInsert) {
        Eleve eleve = eleveMapper.toEntity((toInsert));
        eleve = eleveRespository.save(eleve);

        return eleveMapper.toDto(eleve);
    }

    @Override
    public EleveDTO update(Long id, EleveForm toUpdate) {
        Eleve eleve  = eleveRespository.findById(id).
                orElseThrow(() -> new ElementNotFoundException(Eleve.class , id ));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(e -> e.getAuthority().equals("ROLE_ADMIN"));
        boolean isOwner = eleve.getUtilisateur().getUsername().equals(authentication.getName());

        if (!isAdmin && !isOwner)
            throw new UserNotTheSameException(eleve.getUtilisateur().getUsername(), authentication.getName());

        if (toUpdate.getNom() != null)
            eleve.setNom(toUpdate.getNom());
        if (toUpdate.getPrenom() != null)
            eleve.setPrenom(toUpdate.getPrenom());
        if (toUpdate.getClasse() != null)
            eleve.setClasse(toUpdate.getClasse());
        return eleveMapper.toDto((eleve));
    }

    @Override
    public EleveDTO getOne(Long id) {
        return eleveRespository.findById(id)
                .map(eleveMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Eleve.class, id));
    }

    @Override
    public List<EleveDTO> getAll() {
        return eleveRespository.findAll().stream()
                .map(eleveMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EleveDTO delete(Long id) {

       return eleveRespository.findById(id)
                .map(eleveMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Eleve.class, id));
    }
}
