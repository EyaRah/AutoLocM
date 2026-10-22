package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.services.IClient;
import java.util.List;
@Tag(name = "Gestion Client")
@RestController
@RequestMapping("/api/Client")
@RequiredArgsConstructor
public class ClientController {
    private final IClient iClient;
    @Operation(description = "ajouter un client")
    @PostMapping("/addClient")
    public Client addClient(@Valid @RequestBody Client client) {
        return iClient.ajouterClient( client);
    }
    @Operation(description = "récupérer tous les clients de la base de données")
    @GetMapping("/GetAll")
    public List<Client> getAllClient() {return iClient.recupererClients();}
    @Operation(description = "récupérer un client par son id")
    @GetMapping("/GetClient/{idClient}")
    public Client getClient(@PathVariable("idClient") Long id) {
        return iClient.recupererClientById(id);
    }
    @Operation(description = "supprimer un client par son id")
    @DeleteMapping("/DeleteClient/{idClient}")
    public void deleteClient(@PathVariable("idClient") Long id) {
        iClient.supprimerClient(id);
    }
    @Operation(description = "modifier un client")
    @PutMapping("/updateClient")
    public Client updateClient(@Valid @RequestBody Client client) {
        return iClient.modifierClient( client);
    }
}


