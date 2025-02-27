package tn.esprit.tpfoyerr.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity


public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;

    private String nomUniversite;

    private String adresse;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Foyer foyer;

    public long getIdUniversite() {
        return idUniversite;
    }

    public String getNomUniversite() {
        return nomUniversite;
    }

    public String getAdresse() {
        return adresse;
    }

    public Universite(long idUniversite, String nomUniversite, String adresse, Foyer foyer) {
        this.idUniversite = idUniversite;
        this.nomUniversite = nomUniversite;
        this.adresse = adresse;
        this.foyer = foyer;
    }

    public Universite() {
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setIdUniversite(long idUniversite) {
        this.idUniversite = idUniversite;
    }

    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }
}

