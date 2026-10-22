package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.services.IAgence;
import java.util.List;
@Tag(name = "Gestion Agence")
@RestController
@RequestMapping("/api/Agence")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgence iAgence;
    @Operation(description = "ajouter une agence")
    @PostMapping("/addAgence")
    public Agence addAgence(@Valid @RequestBody Agence agence) {
        return iAgence.ajouterAgence(agence);
    }
    @Operation(description = "récupérer toutes les agences de la base de données")
    @GetMapping("/GetAll")
    public List<Agence> getAllAgence() {return iAgence.recupererAgences();}
    @Operation(description = "récupérer une agence par son id")
    @GetMapping("/GetAgence/{idAgence}")
    public Agence getAgence(@PathVariable("idAgence") Long id) {
        return iAgence.recupererAgenceById(id);
    }
    @Operation(description = "supprimer une agence par son id")
    @DeleteMapping("/DeleteAgence/{idAgence}")
    public void deleteAgence(@PathVariable("idAgence") Long id) {
        iAgence.supprimerAgence(id);
    }
    @Operation(description = "modifier une agence")
    @PutMapping("/updateAgence")
    public Agence updateAgence(@Valid @RequestBody Agence agence) {
        return iAgence.modifierAgence(agence);
    }
}
