package bxl.model.entities;

import lombok.* ;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private  Utilisateur utilisateur;

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }


    public Personne(String prenom, String nom, Utilisateur utilisateur) {
    }
}
