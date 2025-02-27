package tn.esprit.tpfoyerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyerr.entity.Chambre;
@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {

}
