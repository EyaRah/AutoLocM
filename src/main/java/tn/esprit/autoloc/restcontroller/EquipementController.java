package tn.esprit.autoloc.restcontroller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.services.IEquipement;
import java.util.List;
@RestController
@RequestMapping("/api/Equipement")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipement iEquipement;
    @PostMapping("/addEquipement")
    public Equipement addEquipement(@Valid @RequestBody Equipement equipement) {return iEquipement.ajouterEquipement(equipement);}
    @GetMapping("/GetAll")
    public List<Equipement> getAllEquipement() {return iEquipement.recupererEquipements();}
    @GetMapping("/GetEquipement/{idEquipement}")
    public Equipement getEquipement(@PathVariable("idEquipement") Long id) {return iEquipement.recupererEquipementById(id);}
    @DeleteMapping("/DeleteEquipement/{idEquipement}")
    public void deleteEquipement(@PathVariable("idEquipement") Long id) {
        iEquipement.supprimerEquipement(id);
    }
    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@Valid @RequestBody Equipement equipement) {return iEquipement.modifierEquipement(equipement);}
}
