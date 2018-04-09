package com.kevatsaapas.kyselydemo.model;

import javax.persistence.*;

@Entity
public class Kysymysvastaus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vastausTeksi;

    @ManyToOne
    @JoinColumn(name = "kysymysid")
    private Kysymys kysymys;

    @ManyToOne
    @JoinColumn(name = "kyselyvastausid")
    private Kyselyvastaus kyselyvastaus;

    public Kysymys getKysymys() {
        return kysymys;
    }

    public void setKysymys(Kysymys kysymys) {
        this.kysymys = kysymys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVastausTeksi() {
        return vastausTeksi;
    }

    public void setVastausTeksi(String vastausTeksi) {
        this.vastausTeksi = vastausTeksi;
    }

}
