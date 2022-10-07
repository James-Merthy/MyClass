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
            new Utilisateur("prof1", new BCryptPasswordEncoder().encode("pass"), true, List.of("PROF")),
            new Utilisateur("prof2", new BCryptPasswordEncoder().encode("pass"), true, List.of("PROF")),
            new Utilisateur("eleve1", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve2", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve3", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve4", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve5", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve6", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve7", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve8", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve9", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve10", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve11", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve12", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve13", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve14", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve15", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve16", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve17", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve18", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve19", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve20", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve21", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve22", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve23", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve24", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT")),
            new Utilisateur("eleve25", new BCryptPasswordEncoder().encode("pass"), true, List.of("STUDENT"))


    );

    private final List<Prof> profs = Arrays.asList(
            new Prof( "James", "Merthy", utilisateurs.get(1)),
            new Prof("Jamson", "Poliakof" , utilisateurs.get(2))
            );

    private final List<Local> local = Arrays.asList(
            new Local ("ClasseA"  ),
            new Local ("ClasseB" )

    );

    private final List<Lecon> lecon = Arrays.asList(
            new Lecon ("Leçon math 1" , profs.get(0)  ),
            new Lecon ("Leçon Français 1" , profs.get(0) ),
            new Lecon ("Leçon Histoire 1", profs.get(1)  ),
            new Lecon ("Leçon Géo 1" , profs.get(0) ),
            new Lecon ("Leçon math 1" , profs.get(1) )
    );


    private final List<Eleve> eleves = Arrays.asList(

            new Eleve ("Aline" , "Aloi" , utilisateurs.get(3) , local.get(0) ),
            new Eleve ("Maxime" , "Dument" , utilisateurs.get(4), local.get(0)),
            new Eleve ("Julie" , "Sautin",  utilisateurs.get(5), local.get(0)),
            new Eleve ("Roxane" , "Lupin", utilisateurs.get(6), local.get(0)),
            new Eleve ("Nathan" , "Denois" , utilisateurs.get(7), local.get(0)),
            new Eleve ("Thomas" , "Deleau", utilisateurs.get(9), local.get(0)),
            new Eleve ("Jessica" , "Part", utilisateurs.get(10), local.get(0)),
            new Eleve ("Malou" , "Quattre", utilisateurs.get(11), local.get(0)),
            new Eleve ("Ruby" , "Dani", utilisateurs.get(12), local.get(0)),
            new Eleve ("Alvyn" , "Ulbert", utilisateurs.get(13), local.get(0)),
            new Eleve ("Manon" , "Cars", utilisateurs.get(14), local.get(0)),
            new Eleve ("Cyril" , "Echevin", utilisateurs.get(15), local.get(0)),
            new Eleve ("Solena" , "Leclaire", utilisateurs.get(16), local.get(1)),
            new Eleve ("Brandon" , "Reas", utilisateurs.get(17), local.get(1)),
            new Eleve ("Charlotte" , "Jessy", utilisateurs.get(18), local.get(1)),
            new Eleve ("William" , "Larcher", utilisateurs.get(19), local.get(1)),
            new Eleve ("Sephora" , "Safu", utilisateurs.get(20), local.get(1)),
            new Eleve ("Nigel" , "Nseka", utilisateurs.get(21), local.get(1)),
            new Eleve ("Sara" , "Motema", utilisateurs.get(22), local.get(1)),
            new Eleve ("Jean" , "David" , utilisateurs.get(23), local.get(0) ),
            new Eleve ("Jeremy" , "Defalque", utilisateurs.get(24), local.get(1)),
            new Eleve ("Laura" , "Lokombe", utilisateurs.get(25), local.get(1)),
            new Eleve ("Frédaric" , "Kalonda", utilisateurs.get(26), local.get(1)),
            new Eleve ("Marie" , "Van De Paule", utilisateurs.get(27), local.get(1)),
            new Eleve ("Jack" , "Daniels", utilisateurs.get(8), local.get(1))
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
