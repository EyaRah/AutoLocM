package tn.esprit.autoloc.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repositories.EmployeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {
    private final EmployeRepository employeRepository;
    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
    @Override
    public void supprimerEmploye(Long id) {
        employeRepository.deleteById(id);
    }
    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
    @Override
    public List<Employe> recupererEmployes() {
        return employeRepository.findAll();
    }
    @Override
    public Set<Employe> findEmployes() {
        return new HashSet<>(employeRepository.findAll());
    }
    @Override
    public Employe recupererEmployeById(Long id) {
        return employeRepository.findById(id).orElseThrow();
    }
}
