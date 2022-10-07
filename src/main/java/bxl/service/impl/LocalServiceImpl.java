package bxl.service.impl;

import bxl.exceptions.ElementNotFoundException;
import bxl.mapper.LocalMapper;
import bxl.model.dto.LocalDTO;
import bxl.model.entities.Eleve;
import bxl.model.entities.Local;
import bxl.model.entities.Prof;
import bxl.model.forms.LocalInsertForm;
import bxl.model.forms.LocalUpdateForm;
import bxl.repository.LocalRespository;
import bxl.service.LocalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalServiceImpl implements LocalService {

    private final LocalRespository localRespository ;

    private final LocalMapper localMapper ;


    public LocalServiceImpl(LocalRespository localRespository, LocalMapper localMapper) {
        this.localRespository = localRespository;
        this.localMapper = localMapper;
    }

    @Override
    public LocalDTO create(LocalInsertForm toInsert) {
        Local local = localMapper.toEntity((toInsert));
        local = localRespository.save(local);

        return localMapper.toDto(local);
    }

    //pas fini
    @Override
    public LocalDTO update(Long id, LocalUpdateForm toUpdate) {
        Local local  = localRespository.findById(id).
                orElseThrow(() -> new ElementNotFoundException(Eleve.class , id ));
        if (toUpdate.getNom() != null)
            local.setNom(toUpdate.getNom());


        return localMapper.toDto((local));
    }

    @Override
    public LocalDTO getOne(Long id) {
        return localRespository.findById(id)
                .map(localMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Local.class, id));
    }

    @Override
    public List<LocalDTO> getAll() {
        return localRespository.findAll().stream()
                .map(localMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocalDTO delete(Long id) {
        Local toDelete = localRespository.findById(id)
//                .map(eleveMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Local.class, id));

        localRespository.delete(toDelete);
        return localMapper.toDto( toDelete );
    }
}
