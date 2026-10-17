package tn.esprit.autoloc.services;
import tn.esprit.autoloc.entities.Equipement;

import java.util.List;
import java.util.Set;
public interface IEquipement {
    Equipement ajouterEquipement(Equipement equipement);
    void supprimerEquipement(Long id);
    Equipement modifierEquipement(Equipement equipement);
    List<Equipement> recupererEquipements();
    Set<Equipement> findEquipements();
    Equipement recupererEquipementById(Long id);
}
