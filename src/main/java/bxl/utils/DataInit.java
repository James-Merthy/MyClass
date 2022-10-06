package bxl.utils;

import bxl.model.entities.*;
import bxl.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {
    private final UtilisateurRespository utilisateurRespository;
    private final ProfRespository profRespository;
    private final EleveRespository eleveRespository ;

    private final LocalRespository localRespository ;

    private final LeconRespository leconRespository ;


    public DataInit(UtilisateurRespository userRepository, ProfRespository profRespository, EleveRespository eleveRespository, LocalRespository localRespository, LeconRespository leconRespository) {
        this.utilisateurRespository = userRepository;
        this.profRespository = profRespository;
        this.eleveRespository = eleveRespository;
        this.localRespository = localRespository;
        this.leconRespository = leconRespository;
    }

    private final List<Utilisateur> utilisateurs = Arrays.asList(
            new Utilisateur("admin", new BCryptPasswordEncoder().encode("pass"), true, List.of("ADMIN")),
            new Utilisateur("prof1", new BCryptPasswordEncoder().encode("pass"), true, List.of("USER")),
            new Utilisateur("Eleve", new BCryptPasswordEncoder().encode("pass"), true, List.of("USER"))
    );

    private final List<Prof> profs = Arrays.asList(
            new Prof("James", "Merthy" ),
            new Prof("Jamson", "Poliakof")
            );

    private final List<Local> local = Arrays.asList(
            new Local ("ClasseA" , profs.get(0) ),
            new Local ("ClasseB" , profs.get(1))

    );

    private final List<Lecon> lecon = Arrays.asList(
            new Lecon ("Leçon math 1" , profs.get(0) , local.get(0) ),
            new Lecon ("Leçon Français 1" , profs.get(0) , local.get(0) ),
            new Lecon ("Leçon Histoire 1", profs.get(1) , local.get(1) ),
            new Lecon ("Leçon Géo 1" , profs.get(0) , local.get(0) ),
            new Lecon ("Leçon math 1" , profs.get(1) , local.get(1) )
    );


    private final List<Eleve> eleves = Arrays.asList(

            new Eleve ("Aline" , "Aloi" , local.get(0) ),
            new Eleve ("Maxime" , "Dument" , local.get(0)),
            new Eleve ("Julie" , "Sautin", local.get(0)),
            new Eleve ("Roxane" , "Lupin", local.get(0)),
            new Eleve ("Nathan" , "Denois", local.get(0)),
            new Eleve ("Thomas" , "Deleau", local.get(0)),
            new Eleve ("Jessica" , "Part", local.get(0)),
            new Eleve ("Malou" , "Quattre", local.get(0)),
            new Eleve ("Ruby" , "Dani", local.get(0)),
            new Eleve ("Alvyn" , "Ulbert", local.get(0)),
            new Eleve ("Manon" , "Cars", local.get(0)),
            new Eleve ("Cyril" , "Echevin", local.get(0)),
            new Eleve ("Solena" , "Leclaire", local.get(1)),
            new Eleve ("Brandon" , "Reas", local.get(1)),
            new Eleve ("Charlotte" , "Jessy", local.get(1)),
            new Eleve ("William" , "Larcher", local.get(1)),
            new Eleve ("Sephora" , "Safu", local.get(1)),
            new Eleve ("Nigel" , "Nseka", local.get(1)),
            new Eleve ("Sara" , "Motema", local.get(1)),
            new Eleve ("Jean" , "David" , local.get(0) ),
            new Eleve ("Jeremy" , "Defalque", local.get(1)),
            new Eleve ("Laura" , "Lokombe", local.get(1)),
            new Eleve ("Frédaric" , "Kalonda", local.get(1)),
            new Eleve ("Marie" , "Van De Paule", local.get(1)),
            new Eleve ("Jack" , "Daniels", local.get(1))
    );

    @Override
    public void afterPropertiesSet() {
        utilisateurRespository.saveAll(utilisateurs);
        profRespository.saveAll(profs);
        localRespository.saveAll(local);
        leconRespository.saveAll(lecon);
        eleveRespository.saveAll(eleves);

    }
}
