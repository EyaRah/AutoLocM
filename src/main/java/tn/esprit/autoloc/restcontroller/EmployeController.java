package tn.esprit.autoloc.restcontroller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmploye;
import java.util.List;
@RestController
@RequestMapping("/api/Employe")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmploye iEmploye;
    @PostMapping("/addEmploye")
    public Employe addEmploye(@Valid @RequestBody Employe employe) {
        return iEmploye.ajouterEmploye(employe);
    }
    @GetMapping("/GetAll")
    public List<Employe> getAllEmploye() {return iEmploye.recupererEmployes();}
    @GetMapping("/GetEmploye/{idEmploye}")
    public Employe getEmploye(@PathVariable("idEmploye") Long id) {
        return iEmploye.recupererEmployeById(id);
    }
    @DeleteMapping("/DeleteEmploye/{idEmploye}")
    public void deleteEmploye(@PathVariable("idEmploye") Long id) {
        iEmploye.supprimerEmploye(id);
    }
    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@Valid @RequestBody Employe employe) {
        return iEmploye.modifierEmploye(employe);
    }
}
