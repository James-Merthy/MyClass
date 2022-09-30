package bxl.service.impl;

import bxl.mapper.ProfMapper;
import bxl.model.dto.ProfDTO;
import bxl.model.forms.ProfInsertForm;
import bxl.model.forms.ProfUpdateForm;
import bxl.repository.ProfRespository;
import bxl.service.EleveService;
import bxl.service.ProfService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public ProfDTO update(Long id, ProfUpdateForm toUpdate) {
        return null;
    }

    @Override
    public ProfDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<ProfDTO> getAll() {
        return null;
    }

    @Override
    public ProfDTO delete(Long id) {
        return null;
    }
}
