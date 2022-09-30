package bxl.service.impl;

import bxl.mapper.LeconMapper;
import bxl.model.dto.LeconDTO;
import bxl.model.forms.LeconForm;
import bxl.repository.LeconRespository;
import bxl.service.LeconService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public LeconDTO update(Long id, LeconForm toUpdate) {
        return null;
    }

    @Override
    public LeconDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<LeconDTO> getAll() {
        return null;
    }

    @Override
    public LeconDTO delete(Long id) {
        return null;
    }
}
