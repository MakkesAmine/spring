package tn.esprit.tpfoyerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyerr.entity.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
