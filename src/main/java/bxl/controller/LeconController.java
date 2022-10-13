package bxl.controller;

import bxl.model.dto.EleveDTO;
import bxl.model.dto.LeconDTO;
import bxl.model.entities.Lecon;
import bxl.model.forms.EleveForm;
import bxl.model.forms.LeconForm;
import bxl.service.EleveService;
import bxl.service.LeconService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(/*origins= "http://localhost:4200"*/)
@RestController
@RequestMapping("/lecon")

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

    @PreAuthorize("hasRole('PROF')") // ROLE_PROF
    @PostMapping
    public LeconDTO insert(@Valid @RequestBody LeconForm form, Authentication auth) {
        return service.create(form,auth);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PROF')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LeconDTO delete(@PathVariable long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public LeconDTO update(@PathVariable long id, @Valid @RequestBody LeconForm form) {
        return service.update(id, form);
    }

}
