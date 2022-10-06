package bxl.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Eleve extends Personne{

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Local classe ;


    public Eleve( String prenom, String nom, Utilisateur utilisateur, Local classe) {
        super( prenom, nom, utilisateur);
        this.classe = classe;
    }

    public Eleve(String prenom, String nom , Local local) {
        super(prenom, nom);
    }

}
