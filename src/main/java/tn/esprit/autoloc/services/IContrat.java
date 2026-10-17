package tn.esprit.autoloc.services;
import tn.esprit.autoloc.entities.Contrat;

import java.util.List;
import java.util.Set;
public interface IContrat {
    Contrat ajouterContrat(Contrat contrat);
    void supprimerContrat(Long id);
    Contrat modifierContrat(Contrat contrat);
    List<Contrat> recupererContrats();
    Set<Contrat> findContrats();
    Contrat recupererContratById(Long id);
}
