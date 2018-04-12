package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long kysymysid;
    private String kysymysTeksti;

    public Kysymys(String kysymysTeksti) {
        super();
        this.kysymysTeksti = kysymysTeksti;
    }

    public Kysymys() {
        super();
        this.kysymysTeksti = null;
    }

    /**
     * Yhdistetään kysymykset kyselyyn ja get-set
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "kyselyid")
    private Kysely kysely;

    @OneToMany
    private List<Kysymysvastaus> kysymysvastaukset;

    public List<Kysymysvastaus> getKysymysvastaukset() {
        return kysymysvastaukset;
    }

    public void getKysely(Kysely kysely){
        this.kysely = kysely;
    }

    public void setKysely(Kysely kysely){
        this.kysely = kysely;
    }

    public long getId() {
        return kysymysid;
    }

    public void setId(long id) {
        this.kysymysid = id;
    }

    public String getKysymysTeksti() {
        return kysymysTeksti;
    }

    public void setKysymysTeksti(String kysymysTeksti) {
        this.kysymysTeksti = kysymysTeksti;
    }

    @Override
    public String toString() {
        return "Kysymys [id=" + kysymysid + ", kysymysTeksti=" + kysymysTeksti + "]";
    }



}
