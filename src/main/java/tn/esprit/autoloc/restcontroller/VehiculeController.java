package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.services.IVehicule;
import java.util.List;
@Tag(name = "Gestion Vehicule")
@RestController
@RequestMapping("/api/Vehicule")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehicule iVehicule;
    @Operation(description = "ajouter un véhicule")
    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@Valid @RequestBody Vehicule vehicule) {
        return iVehicule.ajouterVehicule(vehicule);
    }
    @Operation(description = "récupérer tous les véhicules de la base de données")
    @GetMapping("/GetAll")
    public List<Vehicule> getAllVehicule() {return iVehicule.recupererVehicules();}
    @Operation(description = "récupérer un véhicule par son id")
    @GetMapping("/GetVehicule/{idVehicule}")
    public Vehicule getVehicule(@PathVariable("idVehicule") Long id) {
        return iVehicule.recupererVehiculeById(id);
    }
    @Operation(description = "supprimer un véhicule par son id")
    @DeleteMapping("/DeleteVehicule/{idVehicule}")
    public void deleteVehicule(@PathVariable("idVehicule") Long id) {
        iVehicule.supprimerVehicule(id);
    }
    @Operation(description = "modifier un véhicule")
    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@Valid @RequestBody Vehicule vehicule) {return iVehicule.modifierVehicule(vehicule);}
}
