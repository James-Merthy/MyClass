package bxl.service.impl;

import bxl.mapper.EleveMapper;
import bxl.model.dto.EleveDTO;
import bxl.model.forms.EleveForm;
import bxl.repository.EleveRespository;
import bxl.service.EleveService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public EleveDTO update(Long id, EleveForm toUpdate) {
        return null;
    }

    @Override
    public EleveDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<EleveDTO> getAll() {
        return null;
    }

    @Override
    public EleveDTO delete(Long id) {
        return null;
    }
}
