package bxl.controller;

import bxl.model.dto.LocalDTO;
import bxl.model.dto.ProfDTO;
import bxl.model.forms.LocalInsertForm;
import bxl.model.forms.LocalUpdateForm;
import bxl.model.forms.ProfInsertForm;
import bxl.model.forms.ProfUpdateForm;
import bxl.service.LocalService;
import bxl.service.ProfService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/local")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    // GET http://localhost:8080/tuteur/{id}
    @GetMapping("/{id:[0-9]+}")
    public LocalDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping({ "", "/all" })
    public List<LocalDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public LocalDTO insert(@Valid @RequestBody LocalInsertForm form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LocalDTO delete(@PathVariable long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public LocalDTO update(@PathVariable long id, @Valid @RequestBody LocalUpdateForm form) {
        return service.update(id, form);
    }
}
