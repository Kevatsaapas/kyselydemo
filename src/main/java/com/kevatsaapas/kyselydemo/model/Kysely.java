package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long kysely_id;

    private String kyselyn_nimi;

    @OneToMany
    private List<Kysymys> kysymysList;

    /**
     * Tyhjä konstruktori
     */
    public Kysely() { }

    public Kysely(String kyselyn_nimi) {
        this.kyselyn_nimi = kyselyn_nimi;
    }

    public long getKyselyId() {
        return kysely_id;
    }

    public void setKyselyId(long kysely_id) {
        this.kysely_id = kysely_id;
    }

    public String getkysely() {
        return kyselyn_nimi;
    }

    public void setkysely(String kyselyn_nimi) {
        this.kyselyn_nimi = kyselyn_nimi;
    }

    @Override
    public String toString() {
        return "";

}

    public List<Kysymys> getKysymysList(){
        return kysymysList;
    }
}
