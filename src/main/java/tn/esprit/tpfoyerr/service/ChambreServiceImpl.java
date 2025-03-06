package tn.esprit.tpfoyerr.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Reservation;
import tn.esprit.tpfoyerr.repository.ChambreRepository;
import tn.esprit.tpfoyerr.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    ChambreRepository chambreRepository ;
    ReservationRepository reservationRepository ;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();

    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    @Transactional
    public Chambre createChambreAndReservation(Chambre chambre, Reservation reservation) {
        chambre.getReservations().add(reservation);
        reservation.setChambre(chambre);
        chambreRepository.save(chambre);
        reservationRepository.save(reservation);
        return chambre;
    }

    @Override
    @Transactional
    public void assignReservationToChambre(Long chambreId, Long reservationId) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation non trouvée"));

        chambre.getReservations().add(reservation);
        reservation.setChambre(chambre);

        chambreRepository.save(chambre);
        reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public void unassignReservationFromChambre(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation non trouvée"));
        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            reservation.setChambre(null);
            chambreRepository.save(chambre);
            reservationRepository.save(reservation);
        }
    }
}
