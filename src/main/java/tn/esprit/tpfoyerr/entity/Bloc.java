package tn.esprit.tpfoyerr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Entity

public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;

    private String nomBloc;

    private long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;

    public Bloc(long idBloc, String nomBloc, long capaciteBloc, Foyer foyer, Set<Chambre> chambres) {
        this.idBloc = idBloc;
        this.nomBloc = nomBloc;
        this.capaciteBloc = capaciteBloc;
        this.foyer = foyer;
        this.chambres = chambres;
    }

    public Bloc() {
    }

    public long getIdBloc() {
        return idBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public long getCapaciteBloc() {
        return capaciteBloc;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setIdBloc(long idBloc) {
        this.idBloc = idBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public void setCapaciteBloc(long capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public void setChambres(Set<Chambre> chambres) {
        this.chambres = chambres;
    }

    public Set<Chambre> getChambres() {
        return chambres;
    }
}