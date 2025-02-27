package tn.esprit.tpfoyerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyerr.entity.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
