package tn.esprit.tpfoyerr.service;

import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Reservation;

import java.util.List;

public interface IReservationService
{
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long reservationId);
    public Reservation addReservation(Reservation r);
    public void removeReservation(Long reservationId);
    public Reservation modifyReservation(Reservation reservation);
}
