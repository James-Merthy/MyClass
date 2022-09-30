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

    public Eleve(Long id, String prenom, String nom, Local classe) {
        super(id, prenom, nom);
        this.classe = classe;
    }



    public Eleve(String prenom, String nom, Local classe) {
        super(prenom, nom);
        this.classe = classe;
    }
}
