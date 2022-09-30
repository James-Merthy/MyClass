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
@AllArgsConstructor
public class Prof extends Personne {

    @OneToMany(mappedBy = "prof")
    private Set<Lecon> listLecon = new HashSet<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id" ,referencedColumnName = "classe_id")
    private Local classe;

    public Prof(String prenom, String nom) {
        super(prenom, nom);
    }
}