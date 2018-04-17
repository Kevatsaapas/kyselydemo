package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kysymys")
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long kysymysid;
    private String kysymysTeksti;
    private Long kysely_id;

    public Kysymys(String kysymysTeksti, Long kysely_id) {
        super();
        this.kysymysTeksti = kysymysTeksti;
        this.kysely_id = kysely_id;
    }

    public Kysymys() {
        super();
        this.kysymysTeksti = null;
        this.kysely_id = null;
    }

    /**
     * Yhdistetään kysymykset kyselyyn ja get-set
     */


    @OneToMany
    private List<Kysymysvastaus> kysymysvastaukset;

    public List<Kysymysvastaus> getKysymysvastaukset() {
        return kysymysvastaukset;
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
        return "Kysymys{" +
                "kysymysid=" + kysymysid +
                ", kysymysTeksti='" + kysymysTeksti + '\'' +
                ", kysely_id=" + kysely_id +

                '}';
    }
}
