package tn.esprit.tpfoyerr.service;

import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants() ;

    public Etudiant retrieveEtudiant(Long etudiantId) ;
    public Etudiant addEtudiant(Etudiant e) ;

    public void removeEtudiant(Long etudiantId) ;
    public Etudiant modifyEtudiant(Etudiant etudiant) ;
}
