package com.kevatsaapas.kyselydemo.model;

import javax.persistence.*;

@Entity
public class Kysymysvastaus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vastaus;
    private Long kysymysId;
    
	public Kysymysvastaus() {
		super();
		this.vastaus = null;
		this.kysymysId = null;
	}

	public Kysymysvastaus(String vastaus, Long kysymysId) {
		super();
		this.vastaus = vastaus;
		this.kysymysId = kysymysId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public Long getKysymysId() {
		return kysymysId;
	}

	public void setKysymysId(Long kysymysId) {
		this.kysymysId = kysymysId;
	}

	@Override
	public String toString() {
		return "Kysymysvastaus [id=" + id + ", vastaus=" + vastaus + ", kysymysId=" + kysymysId + "]";
	}

    

}
