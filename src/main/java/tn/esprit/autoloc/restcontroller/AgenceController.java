package tn.esprit.autoloc.restcontroller;
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
    @PostMapping("/addAgence")
    public Agence addAgence(@Valid @RequestBody Agence agence) {
        return iAgence.ajouterAgence(agence);
    }
    @GetMapping("/GetAll")
    public List<Agence> getAllAgence() {return iAgence.recupererAgences();}
    @GetMapping("/GetAgence/{idAgence}")
    public Agence getAgence(@PathVariable("idAgence") Long id) {
        return iAgence.recupererAgenceById(id);
    }
    @DeleteMapping("/DeleteAgence/{idAgence}")
    public void deleteAgence(@PathVariable("idAgence") Long id) {
        iAgence.supprimerAgence(id);
    }
    @PutMapping("/updateAgence")
    public Agence updateAgence(@Valid @RequestBody Agence agence) {
        return iAgence.modifierAgence(agence);
    }
}
