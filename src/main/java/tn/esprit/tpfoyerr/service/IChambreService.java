package tn.esprit.tpfoyerr.service;

import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Reservation;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    Chambre createChambreAndReservation(Chambre chambre, Reservation reservation);
    void assignReservationToChambre(Long chambreId, Long reservationId);
    void unassignReservationFromChambre(Long reservationId);
}
