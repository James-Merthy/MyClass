package bxl.controller;

import bxl.model.dto.TokenDTO;
import bxl.model.dto.UtilisateurDTO;
import bxl.model.forms.*;
import bxl.service.impl.CustomUserDetailsServiceImpl;
import bxl.utils.JwtProvider;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/user")
public class UtilisateurController {

    private final CustomUserDetailsServiceImpl service;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public UtilisateurController(CustomUserDetailsServiceImpl service, AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.service = service;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    @Secured({"ROLE_ADMIN"})
    public void createUser(@Valid @RequestBody UtilisateurCreeForm form){
        service.create(form);
    }

    @PostMapping("/register/prof")
    @Secured({"ROLE_ADMIN"})
    public void createProf(@Valid @RequestBody UtilisateurCreeForm form){
        service.createPof(form);
    }

    @PostMapping("/register/eleve")
    @Secured({"ROLE_ADMIN"})
    public void createEleve(@Valid @RequestBody UtilisateurCreeForm form){
        service.createEleve(form);
    }

    @PostMapping ("/login")
    public TokenDTO login(@Valid @RequestBody LoginForm form){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return new TokenDTO(jwtProvider.createToken(auth));    }

    @GetMapping("/all")
    @Secured({"ROLE_ADMIN"})
    public List<UtilisateurDTO> readAll() {
        return service.readAll("USER");
    }

    @GetMapping("/{id:[0-9]+}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public UtilisateurDTO readOne(@Valid @PathVariable Long id) {
        return service.readOne(id);
    }

    @PatchMapping("/update/{id:[0-9]+}")
    @Secured({"ROLE_ADMIN"})
    public UtilisateurDTO update(@Valid @PathVariable Long id, @Valid @RequestBody UtilisateurUpdateForm form) {
        return service.update(id, form);
    }

}
