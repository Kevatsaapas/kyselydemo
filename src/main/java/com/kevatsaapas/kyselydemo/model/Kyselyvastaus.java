package com.kevatsaapas.kyselydemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kyselyvastaus {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long kyselyvastausid;
    private Long kyselyId;

    @OneToMany
    private List<Kysymysvastaus> vastaukset;	
    
	public Kyselyvastaus() {
		super();
		this.kyselyId = null;
		this.vastaukset = null;
	}

	public Kyselyvastaus( Long kyselyId, List<Kysymysvastaus> vastaukset) {
		super();
		this.kyselyId = kyselyId;
		this.vastaukset = vastaukset;
	}

	public Long getKyselyvastausid() {
		return kyselyvastausid;
	}

	public void setKyselyvastausid(Long kyselyvastausid) {
		this.kyselyvastausid = kyselyvastausid;
	}



	public Long getKyselyId() {
		return kyselyId;
	}

	public void setKyselyId(Long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public List<Kysymysvastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Kysymysvastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	@Override
	public String toString() {
		return "Kyselyvastaus [kyselyvastausid=" + kyselyvastausid + ", kyselyId=" + kyselyId
				+ ", vastaukset=" + vastaukset + "]";
	}

    
}
