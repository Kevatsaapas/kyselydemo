package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kysymys")
public class Kysymys {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kysymysid;

	private String kysymysTeksti;
	private Long kyselyId;
	private String tyyppi;

	@OneToMany
	private List<Vaihtoehto> arvot;

	public Kysymys(String kysymysTeksti, Long kyselyId, String tyyppi, List<Vaihtoehto> arvot,
			List<Kysymysvastaus> kysymysvastaukset) {
		super();
		this.kysymysTeksti = kysymysTeksti;
		this.kyselyId = kyselyId;
		this.tyyppi = tyyppi;
		this.arvot = arvot;
		this.kysymysvastaukset = kysymysvastaukset;
	}

	public Kysymys() {
		super();
		this.kysymysTeksti = null;
		this.kyselyId = null;
		this.tyyppi = null;
		this.arvot = null;
		this.kysymysvastaukset = null;
	}

	@OneToMany
	private List<Kysymysvastaus> kysymysvastaukset;

	public List<Kysymysvastaus> getKysymysvastaukset() {
		return kysymysvastaukset;
	}

	public long getKysymysid() {
		return kysymysid;
	}

	public void setKysymysid(long kysymysid) {
		this.kysymysid = kysymysid;
	}

	public String getKysymysTeksti() {
		return kysymysTeksti;
	}

	public void setKysymysTeksti(String kysymysTeksti) {
		this.kysymysTeksti = kysymysTeksti;
	}

	public Long getKyselyId() {
		return kyselyId;
	}

	public void setKyselyId(Long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public List<Vaihtoehto> getArvot() {
		return arvot;
	}

	public void setArvot(List<Vaihtoehto> arvot) {
		this.arvot = arvot;
	}

	public void setKysymysvastaukset(List<Kysymysvastaus> kysymysvastaukset) {
		this.kysymysvastaukset = kysymysvastaukset;
	}

	@Override
	public String toString() {
		return "Kysymys [kysymysid=" + kysymysid + ", kysymysTeksti=" + kysymysTeksti + ", kyselyId=" + kyselyId
				+ ", tyyppi=" + tyyppi + ", arvot=" + arvot + ", kysymysvastaukset=" + kysymysvastaukset + "]";
	}

}
