package com.kevatsaapas.kyselydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaihtoehto")
public class Vaihtoehto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long vaihtoehtoId;
    private String arvo;
    private long kysymysId;
	public Vaihtoehto(String arvo, long kysymysId) {
		super();
		this.arvo = arvo;
		this.kysymysId = kysymysId;
	}
	public Vaihtoehto() {
		super();
		this.arvo = null;
		this.kysymysId = 0;
	}
	public long getVaihtoehtoId() {
		return vaihtoehtoId;
	}
	public void setVaihtoehtoId(long vaihtoehtoId) {
		this.vaihtoehtoId = vaihtoehtoId;
	}
	public String getArvo() {
		return arvo;
	}
	public void setArvo(String arvo) {
		this.arvo = arvo;
	}
	public long getKysymysId() {
		return kysymysId;
	}
	public void setKysymysId(long kysymysId) {
		this.kysymysId = kysymysId;
	}
	@Override
	public String toString() {
		return "Vaihtoehto [vaihtoehtoId=" + vaihtoehtoId + ", arvo=" + arvo + ", kysymysId=" + kysymysId + "]";
	}
    
	
    
}
