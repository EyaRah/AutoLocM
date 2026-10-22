package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmploye;
import java.util.List;
@Tag(name = "Gestion Employe")
@RestController
@RequestMapping("/api/Employe")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmploye iEmploye;
    @Operation(description = "ajouter un employé")
    @PostMapping("/addEmploye")
    public Employe addEmploye(@Valid @RequestBody Employe employe) {
        return iEmploye.ajouterEmploye(employe);
    }
    @Operation(description = "récupérer tous les employés de la base de données")
    @GetMapping("/GetAll")
    public List<Employe> getAllEmploye() {return iEmploye.recupererEmployes();}
    @Operation(description = "récupérer un employé par son id")
    @GetMapping("/GetEmploye/{idEmploye}")
    public Employe getEmploye(@PathVariable("idEmploye") Long id) {
        return iEmploye.recupererEmployeById(id);
    }
    @Operation(description = "supprimer un employé par son id")
    @DeleteMapping("/DeleteEmploye/{idEmploye}")
    public void deleteEmploye(@PathVariable("idEmploye") Long id) {
        iEmploye.supprimerEmploye(id);
    }
    @Operation(description = "modifier un employé")
    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@Valid @RequestBody Employe employe) {
        return iEmploye.modifierEmploye(employe);
    }
}
