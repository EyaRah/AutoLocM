package tn.esprit.autoloc.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {
    private final VehiculeRepository vehiculeRepository;
    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {return vehiculeRepository.save(vehicule);}
    @Override
    public List<Vehicule> recupererVehicules() {return vehiculeRepository.findAll();}
    @Override
    public Set<Vehicule> findVehicules() {return new HashSet<>(vehiculeRepository.findAll());}
    @Override public Vehicule recupererVehiculeById(Long id) {return vehiculeRepository.findById(id).orElseThrow();}
}
