package tn.esprit.tpfoyerr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Date;
import java.util.Set;


@Builder
@Entity

public class Reservation {
    public Reservation(String idReservation, Date anneeUniversitaire, boolean estValide, Set<Etudiant> etudiants) {
        this.idReservation = idReservation;
        this.anneeUniversitaire = anneeUniversitaire;
        this.estValide = estValide;
        this.etudiants = etudiants;
    }

    public Reservation() {
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public Date getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    @Id

    private String idReservation;

    private Date anneeUniversitaire;

    private boolean estValide;

    @ManyToMany
    private Set<Etudiant> etudiants;





}