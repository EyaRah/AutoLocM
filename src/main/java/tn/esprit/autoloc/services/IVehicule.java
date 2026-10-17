package tn.esprit.autoloc.services;
import tn.esprit.autoloc.entities.Vehicule;

import java.util.List;
import java.util.Set;
public interface IVehicule {
    Vehicule ajouterVehicule(Vehicule vehicule);
    void supprimerVehicule(Long id);
    Vehicule modifierVehicule(Vehicule vehicule);
    List<Vehicule> recupererVehicules();
    Set<Vehicule> findVehicules();
    Vehicule recupererVehiculeById(Long id);
}
