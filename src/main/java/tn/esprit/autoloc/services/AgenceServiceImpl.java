package tn.esprit.autoloc.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repositories.AgenceRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgence {
    private final AgenceRepository agenceRepository;
    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }
    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);
    }
    @Override
    public Agence modifierAgence(Agence agence) {return agenceRepository.save(agence);}
    @Override
    public List<Agence> recupererAgences() {
        return agenceRepository.findAll();
    }
    @Override
    public Set<Agence> findAgences() {
        return new HashSet<>(agenceRepository.findAll());
    }
    @Override
    public Agence recupererAgenceById(Long id) {
        return agenceRepository.findById(id).orElseThrow();
    }
}
