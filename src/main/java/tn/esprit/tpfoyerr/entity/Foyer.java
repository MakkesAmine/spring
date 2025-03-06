package tn.esprit.tpfoyerr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


//@ToString(exclude = {"idFoyer"})
//@EqualsAndHashCode(exclude = {"idFoyer"})
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@Builder

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    private Universite universite;


    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bloc> blocs=new HashSet<Bloc>()  ;


    public Foyer(long idFoyer, long capaciteFoyer, String nomFoyer, Universite universite, Set<Bloc> blocs) {
        this.idFoyer = idFoyer;
        this.capaciteFoyer = capaciteFoyer;
        this.nomFoyer = nomFoyer;
        this.universite = universite;
        this.blocs = blocs;
    }

    public Foyer() {
    }

    public long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public long getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public void setCapaciteFoyer(long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Set<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(Set<Bloc> blocs) {
        this.blocs = blocs;
    }

    @Override
    public String toString() {
        return "Foyer{" +
                "idFoyer=" + idFoyer +
                ", nomFoyer='" + nomFoyer + '\'' +
                ", capaciteFoyer=" + capaciteFoyer +
                ", universite=" + universite +
                ", blocs=" + blocs +
                '}';
    }
}