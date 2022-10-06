package bxl.service.impl;

import bxl.exceptions.ElementNotFoundException;
import bxl.mapper.LeconMapper;
import bxl.model.dto.LeconDTO;
import bxl.model.entities.Eleve;
import bxl.model.entities.Lecon;
import bxl.model.entities.Local;
import bxl.model.forms.LeconForm;
import bxl.repository.LeconRespository;
import bxl.service.LeconService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeconServiceImpl implements LeconService {

    private final LeconRespository leconRespository ;

    private final LeconMapper leconMapper ;

    public LeconServiceImpl(LeconRespository leconRespository, LeconMapper leconMapper) {
        this.leconRespository = leconRespository;
        this.leconMapper = leconMapper;
    }

    @Override
    public LeconDTO create(LeconForm toInsert) {
        Lecon lecon = leconMapper.toEntity((toInsert));
        lecon = leconRespository.save(lecon);

        return leconMapper.toDto(lecon);
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
        return  leconRespository.findById(id)
                .map(leconMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Lecon.class, id));
    }
}
