package tn.esprit.autoloc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.entities.CategorieVehicule;
import tn.esprit.autoloc.entities.StatutVehicule;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
@Slf4j
public class DemoDataLoader implements CommandLineRunner {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public void run(String... args) {
        if (vehiculeRepository.count() > 0) {
            return;
        }
        List<Vehicule> vehicules = List.of(
                new Vehicule(null, "123 TU 4567", "Renault", "Clio", CategorieVehicule.CITADINE,
                        new BigDecimal("80.00"), StatutVehicule.DISPONIBLE),
                new Vehicule(null, "210 TU 1234", "Peugeot", "508", CategorieVehicule.BERLINE,
                        new BigDecimal("150.00"), StatutVehicule.DISPONIBLE),
                new Vehicule(null, "198 TU 9876", "Kia", "Sportage", CategorieVehicule.SUV,
                        new BigDecimal("180.00"), StatutVehicule.MAINTENANCE)
        );
        vehiculeRepository.saveAll(vehicules);
        log.info("{} véhicules de démonstration insérés", vehicules.size());
    }
}
