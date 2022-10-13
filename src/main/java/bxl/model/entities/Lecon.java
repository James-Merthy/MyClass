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

public class Lecon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecon_id", nullable = false)
    private Long id;

    @Column
    private String nom ;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Prof prof;



    public Lecon(String nom) {
        this.nom = nom;
    }

    public Lecon(String nom, Prof prof) {
        this.nom = nom;
        this.prof = prof;

    }
}