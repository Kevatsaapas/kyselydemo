package com.kevatsaapas.kyselydemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kyselyvastaus {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long kyselyvastausid;
    private String kyselyVastaus;

    @OneToMany
    private List<Kysymysvastaus> kysymysvastaus;

    public Long getKyselyvastausid() {
        return kyselyvastausid;
    }

    public void setKyselyvastausid(Long kyselyvastausid) {
        this.kyselyvastausid = kyselyvastausid;
    }

    public String getKyselyVastaus() {
        return kyselyVastaus;
    }

    public void setKyselyVastaus(String kyselyVastaus) {
        this.kyselyVastaus = kyselyVastaus;
    }

    // Tähän kysymysvastaus.add
}
