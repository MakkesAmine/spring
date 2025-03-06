package tn.esprit.tpfoyerr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;




@Builder
@Entity


public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;


    private String nomEt;


    private String prenomEt;

    private long cin;

    private String ecole;

    private Date dateNaissance;


    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;

    public Etudiant() {
    }

    public Etudiant(long idEtudiant, String nomEt, String prenomEt, long cin, String ecole, Date dateNaissance, Set<Reservation> reservations) {
        this.idEtudiant = idEtudiant;
        this.nomEt = nomEt;
        this.prenomEt = prenomEt;
        this.cin = cin;
        this.ecole = ecole;
        this.dateNaissance = dateNaissance;
        this.reservations = reservations;
    }

    public void setIdEtudiant(long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public long getIdEtudiant() {
        return idEtudiant;
    }

    public String getNomEt() {
        return nomEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public long getCin() {
        return cin;
    }

    public String getEcole() {
        return ecole;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
}