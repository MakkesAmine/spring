package tn.esprit.tpfoyerr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyerr.entity.Foyer;
import tn.esprit.tpfoyerr.entity.Universite;
import tn.esprit.tpfoyerr.repository.FoyerRepository;
import tn.esprit.tpfoyerr.repository.ReservationRepository;
import tn.esprit.tpfoyerr.repository.UniversiteRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository ;
    @Autowired
    FoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long universiteId) {
        return universiteRepository.findById(universiteId).get();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite addFoyerAndUniversitelAndAssign(Universite universite) {
        return universiteRepository.save(universite);


    }

    public void assignFoyerToUniversite(Long foyerId, Long universiteId) {
        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
    }


}
