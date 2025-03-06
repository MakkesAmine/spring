package tn.esprit.tpfoyerr.service;

import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long universiteId);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long universiteId);
    public Universite modifyUniversite(Universite universite);
    public void assignFoyerToUniversite(Long foyerId, Long universiteId);
    public Universite addFoyerAndUniversitelAndAssign(Universite universite);
}
