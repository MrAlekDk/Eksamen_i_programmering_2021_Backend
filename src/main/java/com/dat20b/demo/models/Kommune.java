package com.dat20b.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kommuner")
public class Kommune {

    @Id
    @Column(name = "id", nullable = false,unique = true)
    private Integer kommuneKode;

    private String kommuneNavn;

    @OneToMany(mappedBy="kommune")
    @JsonBackReference
    private List<Parti> allePartier;


    public Kommune(){}

    public Kommune(int kommuneKode, String kommuneNavn) {
        this.kommuneKode = kommuneKode;
        this.kommuneNavn = kommuneNavn;
    }

    public Integer getKommuneKode() {
        return kommuneKode;
    }

    public void setKommuneKode(Integer kommuneKode) {
        this.kommuneKode = kommuneKode;
    }

    public String getKommuneNavn() {
        return kommuneNavn;
    }

    public void setKommuneNavn(String kommuneNavn) {
        this.kommuneNavn = kommuneNavn;
    }
}
