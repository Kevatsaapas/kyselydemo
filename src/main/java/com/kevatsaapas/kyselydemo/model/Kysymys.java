package com.kevatsaapas.kyselydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String kysymysTeksti;

    public Kysymys(String kysymysTeksti) {
        super();
        this.kysymysTeksti = kysymysTeksti;
    }

    public Kysymys() {
        super();
        this.kysymysTeksti = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKysymysTeksti() {
        return kysymysTeksti;
    }

    public void setKysymysTeksti(String kysymysTeksti) {
        this.kysymysTeksti = kysymysTeksti;
    }

    @Override
    public String toString() {
        return "Kysymys [id=" + id + ", kysymysTeksti=" + kysymysTeksti + "]";
    }



}
