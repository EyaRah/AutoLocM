package tn.esprit.autoloc.services;
import tn.esprit.autoloc.entities.Agence;

import java.util.List;
import java.util.Set;
public interface IAgence {
    Agence ajouterAgence(Agence agence);
    void supprimerAgence(Long id);
    Agence modifierAgence(Agence agence);
    List<Agence> recupererAgences();
    Set<Agence> findAgences();
    Agence recupererAgenceById(Long id);
}
