package tn.esprit.tpfoyerr.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyerr.entity.Bloc;
import tn.esprit.tpfoyerr.entity.Foyer;
import tn.esprit.tpfoyerr.repository.BlocRepository;
import tn.esprit.tpfoyerr.repository.FoyerRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository;
    @Autowired
    BlocRepository blocRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).get();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyerId) {
        return foyerRepository.save(foyerId);
    }

    @Override
    @Transactional
    public void assignBlocToFoyer(Long foyerId, Long blocId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        Bloc bloc = blocRepository.findById(blocId)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        bloc.setFoyer(foyer);
        foyer.getBlocs().add(bloc);

        blocRepository.save(bloc);
        foyerRepository.save(foyer);
    }
}
