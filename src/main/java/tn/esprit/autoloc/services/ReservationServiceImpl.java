package tn.esprit.autoloc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.repositories.ReservationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {
    private final ReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Set<Reservation> findReservations() {
        return new HashSet<>(reservationRepository.findAll());
    }

    @Override
    public Reservation recupererReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }
}
