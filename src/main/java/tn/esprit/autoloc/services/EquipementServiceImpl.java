package tn.esprit.autoloc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.repositories.EquipementRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipement {
    private final EquipementRepository equipementRepository;
    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void supprimerEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Equipement modifierEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> recupererEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Set<Equipement> findEquipements() {
        return new HashSet<>(equipementRepository.findAll());
    }

    @Override
    public Equipement recupererEquipementById(Long id) {
        return equipementRepository.findById(id).orElseThrow();
    }
}
