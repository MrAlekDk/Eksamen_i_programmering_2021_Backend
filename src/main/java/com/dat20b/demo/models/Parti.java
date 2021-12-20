package com.dat20b.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "partier")
public class Parti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false,unique = true)
    private Integer partiId;

    @Column(name="party_name")
    private String partiNavn;

    @Column(name="party_letter")
    private Character partiBogstav;

    @OneToMany(mappedBy="parti",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonBackReference("kandidater")
    private List<Kandidat> partiKandidater;

    @ManyToOne
    @JoinColumn(name="kommune_id")
    private Kommune kommune;

    public Parti(){}

    public Parti(String partiNavn, Character partiBogstav, Kommune kommune) {
        this.partiNavn = partiNavn;
        this.partiBogstav = partiBogstav;
        this.kommune = kommune;
    }

    public Integer getPartiId() {
        return partiId;
    }

    public void setPartiId(Integer partiId) {
        this.partiId = partiId;
    }

    public String getPartiNavn() {
        return partiNavn;
    }

    public void setPartiNavn(String partiNavn) {
        this.partiNavn = partiNavn;
    }

    public Character getPartiBogstav() {
        return partiBogstav;
    }

    public void setPartiBogstav(Character partiBogstav) {
        this.partiBogstav = partiBogstav;
    }

    public List<Kandidat> getPartiKandidater() {
        return partiKandidater;
    }

    public void setPartiKandidater(List<Kandidat> partiKandidater) {
        this.partiKandidater = partiKandidater;
    }
}
