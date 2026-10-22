package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.services.IMaintenance;
import java.util.List;
@Tag(name = "Gestion Maintenance")
@RestController
@RequestMapping("/api/Maintenance")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenance iMaintenance;
    @Operation(description = "ajouter une maintenance")
    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@Valid @RequestBody Maintenance maintenance) {return iMaintenance.ajouterMaintenance(maintenance);}
    @Operation(description = "récupérer toutes les maintenances de la base de données")
    @GetMapping("/GetAll")
    public List<Maintenance> getAllMaintenance() {return iMaintenance.recupererMaintenances();}
    @Operation(description = "récupérer une maintenance par son id")
    @GetMapping("/GetMaintenance/{idMaintenance}")
    public Maintenance getMaintenance(@PathVariable("idMaintenance") Long id) {return iMaintenance.recupererMaintenanceById(id);}
    @Operation(description = "supprimer une maintenance par son id")
    @DeleteMapping("/DeleteMaintenance/{idMaintenance}")
    public void deleteMaintenance(@PathVariable("idMaintenance") Long id) {
        iMaintenance.supprimerMaintenance(id);
    }
    @Operation(description = "modifier une maintenance")
    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@Valid @RequestBody Maintenance maintenance) {return iMaintenance.modifierMaintenance(maintenance);}
}
