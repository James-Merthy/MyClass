package bxl.controller;

import bxl.model.dto.EleveDTO;
import bxl.model.forms.EleveForm;
import bxl.service.EleveService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/eleve")

public class EleveController {

    private final EleveService service ;

    public EleveController(EleveService service) {
        this.service = service;
    }


     // coment
    @GetMapping("/{id:[0-9]+}")
    public EleveDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping({ "", "/all" })
    public List<EleveDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public EleveDTO insert(@Valid @RequestBody EleveForm form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EleveDTO delete(@PathVariable long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public EleveDTO update(@PathVariable long id, @Valid @RequestBody EleveForm form) {
        return service.update(id, form);
    }
}
