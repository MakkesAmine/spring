package tn.esprit.tpfoyerr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Builder
@Entity

public class Chambre {
    @Id
    private long idChambre;

    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    public Chambre(long idChambre, long numeroChambre, TypeChambre typeC, Bloc bloc, Set<Reservation> reservations) {
        this.idChambre = idChambre;
        this.numeroChambre = numeroChambre;
        this.typeC = typeC;
        this.bloc = bloc;
        this.reservations = reservations;
    }

    public Chambre() {
    }

    public long getIdChambre() {
        return idChambre;
    }

    public long getNumeroChambre() {
        return numeroChambre;
    }

    public TypeChambre getTypeC() {
        return typeC;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setIdChambre(long idChambre) {
        this.idChambre = idChambre;
    }

    public void setNumeroChambre(long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public void setTypeC(TypeChambre typeC) {
        this.typeC = typeC;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}