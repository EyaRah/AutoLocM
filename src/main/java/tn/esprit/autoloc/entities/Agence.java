package tn.esprit.autoloc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false, length = 50)
    private String ville;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false, length = 20)
    private String telephone;
    @OneToMany(mappedBy = "agence")
    @JsonIgnore

    Set<Employe>  employees = new HashSet<>();
    @OneToMany(mappedBy = "agence")
    @JsonIgnore

    Set<Vehicule>  vehicules = new HashSet<>();

}
