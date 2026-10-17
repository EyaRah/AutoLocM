package tn.esprit.autoloc.restcontroller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContrat;
import java.util.List;
@RestController
@RequestMapping("/api/Contrat")
@RequiredArgsConstructor
public class ContratController {
    private final IContrat iContrat;
    @PostMapping("/addContrat")
    public Contrat addContrat(@Valid @RequestBody Contrat contrat) {
        return iContrat.ajouterContrat(contrat);
    }
    @GetMapping("/GetAll")
    public List<Contrat> getAllContrat() {return iContrat.recupererContrats();}
    @GetMapping("/GetContrat/{idContrat}")
    public Contrat getContrat(@PathVariable("idContrat") Long id) {
        return iContrat.recupererContratById(id);
    }
    @DeleteMapping("/DeleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable("idContrat") Long id) {
        iContrat.supprimerContrat(id);
    }
    @PutMapping("/updateContrat")
    public Contrat updateContrat(@Valid @RequestBody Contrat contrat) {
        return iContrat.modifierContrat(contrat);
    }
}
