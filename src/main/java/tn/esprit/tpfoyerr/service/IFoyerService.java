package tn.esprit.tpfoyerr.service;

import tn.esprit.tpfoyerr.entity.Bloc;
import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long foyerId);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long foyerId);
    public Foyer modifyFoyer(Foyer foyerId) ;
    void assignBlocToFoyer(Long foyerId, Long blocId);
    void unassignBlocFromFoyer(Long blocId);
    Foyer createBlocAndFoyer(Foyer foyer, Bloc bloc);
}
