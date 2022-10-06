package bxl.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classe_id" , nullable = false)
    private Long id;

    private String nom ;

    @OneToOne(mappedBy = "classe")
    private Prof professeur ;



    @OneToMany(mappedBy = "classe")
    private Set <Eleve> nombreEleve = new HashSet<>();


    public Local(String nom) {
        this.nom = nom;
    }

    public Local(String nom, Prof professeur) {
        this.nom = nom;
        this.professeur = professeur;

    }
}