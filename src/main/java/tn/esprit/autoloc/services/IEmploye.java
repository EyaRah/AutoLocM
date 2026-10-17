package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Employe;

import java.util.List;
import java.util.Set;

public interface IEmploye {
    Employe ajouterEmploye(Employe employe);
    void supprimerEmploye(Long id);
    Employe modifierEmploye(Employe employe);
    List<Employe> recupererEmployes();
    Set<Employe> findEmployes();
    Employe recupererEmployeById(Long id);

}
