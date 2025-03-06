package tn.esprit.tpfoyerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyerr.entity.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
