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
    @JoinColumn(name = "prof_id" , nullable = false)
    private Prof prof;

    @ManyToOne
    @JoinColumn(name = "classe_id" , nullable = false)
    private Local classe;


}