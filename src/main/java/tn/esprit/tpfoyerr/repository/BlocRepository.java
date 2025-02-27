package tn.esprit.tpfoyerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyerr.entity.Bloc;
import tn.esprit.tpfoyerr.entity.Chambre;
@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
