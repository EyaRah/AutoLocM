package tn.esprit.autoloc.services;
import tn.esprit.autoloc.entities.Maintenance;

import java.util.List;
import java.util.Set;
public interface IMaintenance {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    void supprimerMaintenance(Long id);
    Maintenance modifierMaintenance(Maintenance maintenance);
    List<Maintenance> recupererMaintenances();
    Set<Maintenance> findMaintenances();
    Maintenance recupererMaintenanceById(Long id);
}
