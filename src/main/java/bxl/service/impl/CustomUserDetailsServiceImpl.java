package bxl.service.impl;

import bxl.exceptions.AlreadyExistsException;
import bxl.exceptions.CannotChangeOtherAdminException;
import bxl.exceptions.ElementNotFoundException;
import bxl.mapper.UtilisateurMapper;
import bxl.model.dto.UtilisateurDTO;
import bxl.model.entities.Utilisateur;
import bxl.model.forms.UtilisateurCreeForm;
import bxl.model.forms.UtilisateurUpdateForm;
import bxl.repository.UtilisateurRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UtilisateurRespository repository;
    private final PasswordEncoder encoder;
    private final UtilisateurMapper userMapper;
//    private final List<String> roles = new ArrayList<>() ;

    public CustomUserDetailsServiceImpl(UtilisateurRespository repository, PasswordEncoder encoder, UtilisateurMapper userMapper) {
        this.repository = repository;
        this.encoder = encoder;
        this.userMapper = userMapper;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("connexion impossible"));
    }

    public void create(UtilisateurCreeForm form) {
        try {

            Utilisateur user = new Utilisateur();//new Utilisateur(form.getUsername(), encoder.encode(form.getPassword()));

            user.setUsername(form.getUsername());
            user.setPassword(encoder.encode(form.getPassword()));

            user.getRoles().add("ADMIN");

            repository.save(user);


        }
        catch(Exception exception) {
            throw new AlreadyExistsException(form.getUsername(), "username");
        }
    }

    public void createPof(UtilisateurCreeForm form) {
        try {
            Utilisateur user = new Utilisateur();//new Utilisateur(form.getUsername(), encoder.encode(form.getPassword()));

            user.setUsername(form.getUsername());
            user.setPassword(encoder.encode(form.getPassword()));
            user.getRoles().add("PROF");

            repository.save(user);
        }
        catch(Exception exception) {
            throw new AlreadyExistsException(form.getUsername(), "username");
//            System.err.println(exception);
        }

    }

    public void createEleve(UtilisateurCreeForm form) {

//        Utilisateur user = new Utilisateur();//new Utilisateur(form.getUsername(), encoder.encode(form.getPassword()));
//
//        user.setUsername(form.getUsername());
//        user.setPassword(encoder.encode(form.getPassword()));
//
////        user.getRoles().add("STUDENT");
//
//        repository.save(user);
        try {
            Utilisateur user = new Utilisateur();//new Utilisateur(form.getUsername(), encoder.encode(form.getPassword()));

            user.setUsername(form.getUsername());
            user.setPassword(encoder.encode(form.getPassword()));

            repository.save(user);
        }
        catch(Exception exception) {
            throw new AlreadyExistsException(form.getUsername(), "username");
        }

//        Utilisateur user = new Utilisateur(form.getUsername(), encoder.encode(form.getPassword()));
//        user.getRoles().add("STUDENT");
//        repository.save(user);
    }

    public List<UtilisateurDTO> readAll(String role) {
        return repository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDTO readOne(Long id) {
        return userMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible.")));
    }

    public UtilisateurDTO update (Long id , UtilisateurUpdateForm form){

        Utilisateur utilisateur = repository.findById(id).orElseThrow(() -> new ElementNotFoundException(Utilisateur.class, id));
        boolean isAdmin = utilisateur.getAuthorities().stream().anyMatch(e -> e.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin)
            throw new CannotChangeOtherAdminException(Utilisateur.class, utilisateur.getUsername());
        if (form.getPassword() != null)
            utilisateur.setPassword(encoder.encode(form.getPassword()));
        return userMapper.toDto(utilisateur);

    }


    public void delete(Long id) {
        Utilisateur user = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Utilisateur.class, id));
        boolean isAdmin = user.getAuthorities().stream().anyMatch(e -> e.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin)
            throw new CannotChangeOtherAdminException(Utilisateur.class, user.getUsername());
        repository.delete(user);
    }


}