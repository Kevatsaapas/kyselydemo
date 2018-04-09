package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long kyselyId;

    private String kyselyNimi;

    @OneToMany
    private List<Kysymys> kysymysList;

    /**
     * Tyhjä konstruktori
     */
    public Kysely() { }

    public long getKyselyId() {
        return kyselyId;
    }

    public void setKyselyId(long kyselyId) {
        this.kyselyId = kyselyId;
    }

    public String getkysely() {
        return kyselyNimi;
    }

    public void setkysely(String kyselyNimi) {
        this.kyselyNimi = kyselyNimi;
    }

    @Override
    public String toString() {
        return "";

}

    public List<Kysymys> getKysymysList(){
        return kysymysList;
    }
}
