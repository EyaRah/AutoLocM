package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContrat;
import java.util.List;
@Tag(name = "Gestion Contrat")
@RestController
@RequestMapping("/api/Contrat")
@RequiredArgsConstructor
public class ContratController {
    private final IContrat iContrat;
    @Operation(description = "ajouter un contrat")
    @PostMapping("/addContrat")
    public Contrat addContrat(@Valid @RequestBody Contrat contrat) {
        return iContrat.ajouterContrat(contrat);
    }
    @Operation(description = "récupérer tous les contrats de la base de données")
    @GetMapping("/GetAll")
    public List<Contrat> getAllContrat() {return iContrat.recupererContrats();}
    @Operation(description = "récupérer un contrat par son id")
    @GetMapping("/GetContrat/{idContrat}")
    public Contrat getContrat(@PathVariable("idContrat") Long id) {
        return iContrat.recupererContratById(id);
    }
    @Operation(description = "supprimer un contrat par son id")
    @DeleteMapping("/DeleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable("idContrat") Long id) {
        iContrat.supprimerContrat(id);
    }
    @Operation(description = "modifier un contrat")
    @PutMapping("/updateContrat")
    public Contrat updateContrat(@Valid @RequestBody Contrat contrat) {
        return iContrat.modifierContrat(contrat);
    }
}
