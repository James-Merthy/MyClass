package bxl.utils;

import bxl.model.entities.Prof;
import bxl.model.entities.Utilisateur;
import bxl.repository.ProfRespository;
import bxl.repository.UtilisateurRespository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {
    private final UtilisateurRespository utilisateurRespository;
    private final ProfRespository profRespository;

    public DataInit(UtilisateurRespository userRepository, ProfRespository profRespository) {
        this.utilisateurRespository = userRepository;
        this.profRespository = profRespository;
    }

    private final List<Utilisateur> utilisateurs = Arrays.asList(
            new Utilisateur("admin@mail.com", new BCryptPasswordEncoder().encode("pass"), true, List.of("ADMIN")),
            new Utilisateur("james@mail.com", new BCryptPasswordEncoder().encode("pass"), true, List.of("USER"))
    );

    private final List<Prof> profs = Arrays.asList(
            new Prof("James", "James")
            );

    @Override
    public void afterPropertiesSet() {
        utilisateurRespository.saveAll(utilisateurs);
        profRespository.saveAll(profs);
    }
}
