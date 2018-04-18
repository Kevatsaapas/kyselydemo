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
    private Long kyselyId;

    public Kysymys(String kysymysTeksti, Long kyselyId) {
        super();
        this.kysymysTeksti = kysymysTeksti;
        this.kyselyId = kyselyId;
    }

    public Kysymys() {
        super();
        this.kysymysTeksti = null;
        this.kyselyId = null;
    }

    /**
     * Yhdistetään kysymykset kyselyyn ja get-set
     */


    @OneToMany
    private List<Kysymysvastaus> kysymysvastaukset;

    public List<Kysymysvastaus> getKysymysvastaukset() {
        return kysymysvastaukset;
    }






    public void setKysymysid(long kysymysid) {
		this.kysymysid = kysymysid;
	}

	public void setKysymysTeksti(String kysymysTeksti) {
		this.kysymysTeksti = kysymysTeksti;
	}

	public void setKyselyId(Long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public void setKysymysvastaukset(List<Kysymysvastaus> kysymysvastaukset) {
		this.kysymysvastaukset = kysymysvastaukset;
	}

	public long getKysymysid() {
		return kysymysid;
	}

	public String getKysymysTeksti() {
		return kysymysTeksti;
	}

	public Long getKyselyId() {
		return kyselyId;
	}

	@Override
    public String toString() {
        return "Kysymys{" +
                "kysymysid=" + kysymysid +
                ", kysymysTeksti='" + kysymysTeksti + '\'' +
                ", kyselyId=" + kyselyId +

                '}';
    }
}
