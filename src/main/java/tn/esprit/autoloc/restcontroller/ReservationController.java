package tn.esprit.autoloc.restcontroller;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.services.IReservation;
import java.util.List;
@Tag(name = "Gestion Reservation")
@RestController
@RequestMapping("/api/Reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservation iReservation;
    @PostMapping("/addReservation")
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {return iReservation.ajouterReservation(reservation);}
    @GetMapping("/GetAll")
    public List<Reservation> getAllReservation() {return iReservation.recupererReservations();}
    @GetMapping("/GetReservation/{idReservation}")
    public Reservation getReservation(@PathVariable("idReservation") Long id) {return iReservation.recupererReservationById(id);}
    @DeleteMapping("/DeleteReservation/{idReservation}")
    public void deleteReservation(@PathVariable("idReservation") Long id) {
        iReservation.supprimerReservation(id);
    }
    @PutMapping("/updateReservation")
    public Reservation updateReservation(@Valid @RequestBody Reservation reservation) {return iReservation.modifierReservation(reservation);}
}
