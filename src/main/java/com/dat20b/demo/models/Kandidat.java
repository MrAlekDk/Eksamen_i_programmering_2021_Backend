package com.dat20b.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "kandidater")
public class Kandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kandidatId;

    @Column(name="name")
    private String navn;

    @Column(name="votes")
    private Integer antalStemmer;

    @ManyToOne
    @JoinColumn(name="parti_id",referencedColumnName = "id")
    private Parti parti;

    public Kandidat(){}

    public Kandidat(String navn, Integer antalStemmer, Parti parti) {
        this.navn = navn;
        this.antalStemmer = antalStemmer;
        this.parti = parti;
    }

    public Integer getKandidatId() {
        return kandidatId;
    }

    public void setKandidatId(Integer kandidatId) {
        this.kandidatId = kandidatId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Integer getAntalStemmer() {
        return antalStemmer;
    }

    public void setAntalStemmer(Integer antalStemmer) {
        this.antalStemmer = antalStemmer;
    }

    public Parti getParti() {
        return parti;
    }

    public void setParti(Parti parti) {
        this.parti = parti;
    }
}
