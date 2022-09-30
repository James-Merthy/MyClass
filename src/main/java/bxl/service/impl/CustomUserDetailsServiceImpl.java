package bxl.service.impl;

import bxl.model.entities.Utilisateur;
import bxl.model.forms.UtilisateurCreeForm;
import bxl.repository.UtilisateurRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UtilisateurRespository repository;
    private final PasswordEncoder encoder;

    public CustomUserDetailsServiceImpl(UtilisateurRespository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("connexion impossible"));
    }

    public void create(UtilisateurCreeForm toCreate){
        Utilisateur utilisateur = toCreate.toEntity();
        utilisateur.setPassword( encoder.encode(utilisateur.getPassword()) );
        repository.save( utilisateur );
    }

}