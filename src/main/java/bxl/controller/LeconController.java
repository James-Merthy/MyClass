package bxl.controller;

import bxl.model.dto.EleveDTO;
import bxl.model.dto.LeconDTO;
import bxl.model.entities.Lecon;
import bxl.model.forms.EleveForm;
import bxl.model.forms.LeconForm;
import bxl.service.EleveService;
import bxl.service.LeconService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Lecon")

public class LeconController {

    private final LeconService service ;

    public LeconController(LeconService service) {
        this.service = service;
    }

    // GET http://localhost:8080/tuteur/{id}
    @GetMapping("/{id:[0-9]+}")
    public LeconDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping({ "", "/all" })
    public List<LeconDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public LeconDTO insert(@Valid @RequestBody LeconForm form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LeconDTO delete(@PathVariable long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public LeconDTO update(@PathVariable long id, @Valid @RequestBody LeconForm form) {
        return service.update(id, form);
    }

}
