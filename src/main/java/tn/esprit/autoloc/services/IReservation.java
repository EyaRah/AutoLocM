package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Reservation;

import java.util.List;
import java.util.Set;

public interface IReservation {
    Reservation ajouterReservation(Reservation reservation);
    void supprimerReservation(Long id);
    Reservation modifierReservation(Reservation reservation);
    List<Reservation> recupererReservations();
    Set<Reservation> findReservations();
    Reservation recupererReservationById(Long id);

}
