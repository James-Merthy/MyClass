package bxl.service.impl;

import bxl.exceptions.ElementNotFoundException;
import bxl.mapper.LeconMapper;
import bxl.model.dto.LeconDTO;
import bxl.model.entities.Lecon;
import bxl.model.entities.Prof;
import bxl.model.forms.LeconForm;
import bxl.repository.LeconRespository;
import bxl.repository.ProfRespository;
import bxl.service.LeconService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeconServiceImpl implements LeconService {

    private final LeconRespository leconRespository ;

    private final LeconMapper leconMapper ;

    private final ProfRespository profRespository;

    public LeconServiceImpl(LeconRespository leconRespository, LeconMapper leconMapper, ProfRespository profRespository) {
        this.leconRespository = leconRespository;
        this.leconMapper = leconMapper;

        this.profRespository = profRespository;
    }

    @Override
    public LeconDTO create(LeconForm toInsert, Authentication auth) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        boolean isProf = authentication.getAuthorities().stream().anyMatch(e -> e.getAuthority().equals("ROLE_PROF"));
//
//        if (!isProf && !isOwner)
//            throw new UserNotTheSameException(prof.getUtilisateur().getUsername(), authentication.getName());
        Lecon lecon = leconMapper.toEntity((toInsert));

        Prof prof = profRespository.findByUtilisateur_Username(auth.getName())
                .orElseThrow( () -> new RuntimeException("Pas de prof avec ce username") );

        lecon.setProf( prof );

        lecon = leconRespository.save(lecon);

        return leconMapper.toDto(lecon);
    }

    @Override
    public LeconDTO create(LeconForm toInsert) {
        return null;
    }

    @Override
    public LeconDTO update(Long id, LeconForm toUpdate) {
        Lecon lecon  = leconRespository.findById(id).
                orElseThrow(() -> new ElementNotFoundException(Lecon.class , id ));
        if (toUpdate.getNom() != null)
            lecon.setNom(toUpdate.getNom());


        return leconMapper.toDto((lecon));
    }

    @Override
    public LeconDTO getOne(Long id) {
        return leconRespository.findById(id)
                .map(leconMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Lecon.class, id));
    }

    @Override
    public List<LeconDTO> getAll() {
        return leconRespository.findAll().stream()
                .map(leconMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LeconDTO delete(Long id) {
        Lecon lecon = leconRespository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Lecon.class, id));
        leconRespository.delete(lecon);

        return null;
    }
}
