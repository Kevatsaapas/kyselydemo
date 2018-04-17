package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "kysely")
public class Kysely {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long kysely_id;

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

    public Long getKyselyId() {
        return kysely_id;
    }

    public void setKyselyId(Long kysely_id) {
        this.kysely_id = kysely_id;
    }

    public String getkysely() {
        return kyselyn_nimi;
    }

    public void setkysely(String kyselyn_nimi) {
        this.kyselyn_nimi = kyselyn_nimi;
    }

    public void setKysymysList(List<Kysymys> kysymysList) {
        this.kysymysList = kysymysList;
    }

    @Override
    public String toString() {
        return "Kysely{" +
                "kysely_id=" + kysely_id +
                ", kyselyn_nimi='" + kyselyn_nimi + '\'' +
                ", kysymysList=" + kysymysList +
                '}';
    }

    public List<Kysymys> getKysymysList(){
        return kysymysList;
    }
}
