package bxl.service.impl;

import bxl.mapper.LocalMapper;
import bxl.model.dto.LocalDTO;
import bxl.model.forms.LocalInsertForm;
import bxl.model.forms.LocalUpdateForm;
import bxl.repository.LocalRespository;
import bxl.service.LocalService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public LocalDTO update(Long id, LocalUpdateForm toUpdate) {
        return null;
    }

    @Override
    public LocalDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<LocalDTO> getAll() {
        return null;
    }

    @Override
    public LocalDTO delete(Long id) {
        return null;
    }
}
