package bxl.controller;

import bxl.model.dto.ProfDTO;
import bxl.model.forms.ProfInsertForm;
import bxl.model.forms.ProfUpdateForm;
import bxl.service.ProfService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/prof")
public class ProfController {

    private final ProfService service;

    public ProfController(ProfService service) {
        this.service = service;
    }

    // GET http://localhost:8080/tuteur/{id}
    @GetMapping("/{id:[0-9]+}")
    public ProfDTO  getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping({ "", "/all" })
    public List<ProfDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ProfDTO insert(@Valid @RequestBody ProfInsertForm form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Secured({"ROLE_ADMIN"})
    public ProfDTO delete(@PathVariable long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ProfDTO update(@PathVariable long id, @Valid @RequestBody ProfUpdateForm form) {
        return service.update(id, form);
    }



}
