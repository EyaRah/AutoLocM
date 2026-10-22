package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.services.IEquipement;
import java.util.List;
@Tag(name = "Gestion Equipement")
@RestController
@RequestMapping("/api/Equipement")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipement iEquipement;
    @Operation(description = "ajouter un équipement")
    @PostMapping("/addEquipement")
    public Equipement addEquipement(@Valid @RequestBody Equipement equipement) {return iEquipement.ajouterEquipement(equipement);}
    @Operation(description = "récupérer tous les équipements de la base de données")
    @GetMapping("/GetAll")
    public List<Equipement> getAllEquipement() {return iEquipement.recupererEquipements();}
    @Operation(description = "récupérer un équipement par son id")
    @GetMapping("/GetEquipement/{idEquipement}")
    public Equipement getEquipement(@PathVariable("idEquipement") Long id) {return iEquipement.recupererEquipementById(id);}
    @Operation(description = "supprimer un équipement par son id")
    @DeleteMapping("/DeleteEquipement/{idEquipement}")
    public void deleteEquipement(@PathVariable("idEquipement") Long id) {
        iEquipement.supprimerEquipement(id);
    }
    @Operation(description = "modifier un équipement")
    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@Valid @RequestBody Equipement equipement) {return iEquipement.modifierEquipement(equipement);}
}
