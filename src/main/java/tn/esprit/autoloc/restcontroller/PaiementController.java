package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.services.IPaiement;
import java.util.List;
@Tag(name = "Gestion Paiement")
@RestController
@RequestMapping("/api/Paiement")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiement iPaiement;
    @Operation(description = "ajouter un paiement")
    @PostMapping("/addPaiement")
    public Paiement addPaiement(@Valid @RequestBody Paiement paiement) {
        return iPaiement.ajouterPaiement(paiement);
    }
    @Operation(description = "récupérer tous les paiements de la base de données")
    @GetMapping("/GetAll")
    public List<Paiement> getAllPaiement() {return iPaiement.recupererPaiements();}
    @Operation(description = "récupérer un paiement par son id")
    @GetMapping("/GetPaiement/{idPaiement}")
    public Paiement getPaiement(@PathVariable("idPaiement") Long id) {
        return iPaiement.recupererPaiementById(id);
    }
    @Operation(description = "supprimer un paiement par son id")
    @DeleteMapping("/DeletePaiement/{idPaiement}")
    public void deletePaiement(@PathVariable("idPaiement") Long id) {
        iPaiement.supprimerPaiement(id);
    }
    @Operation(description = "modifier un paiement")
    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@Valid @RequestBody Paiement paiement) {return iPaiement.modifierPaiement(paiement);}
}
