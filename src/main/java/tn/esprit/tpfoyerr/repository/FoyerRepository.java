package tn.esprit.tpfoyerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyerr.entity.Foyer;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
