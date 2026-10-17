package tn.esprit.autoloc.restcontroller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.services.IVehicule;
import java.util.List;
@RestController
@RequestMapping("/api/Vehicule")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehicule iVehicule;
    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@Valid @RequestBody Vehicule vehicule) {
        return iVehicule.ajouterVehicule(vehicule);
    }
    @GetMapping("/GetAll")
    public List<Vehicule> getAllVehicule() {return iVehicule.recupererVehicules();}
    @GetMapping("/GetVehicule/{idVehicule}")
    public Vehicule getVehicule(@PathVariable("idVehicule") Long id) {
        return iVehicule.recupererVehiculeById(id);
    }
    @DeleteMapping("/DeleteVehicule/{idVehicule}")
    public void deleteVehicule(@PathVariable("idVehicule") Long id) {
        iVehicule.supprimerVehicule(id);
    }
    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@Valid @RequestBody Vehicule vehicule) {return iVehicule.modifierVehicule(vehicule);}
}
