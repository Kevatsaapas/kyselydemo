package com.kevatsaapas.kyselydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import java.util.List;


@Entity
@Table(name = "kysely")
public class Kysely {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long kysely_id;

    private String kyselyn_nimi;

    @Column
    @Length(min=1, max=1000)
    private String kuvaus;
    
    @OneToMany
    private List<Kysymys> kysymysList;

    
    public Kysely(String kyselyn_nimi, @Length(min = 1, max = 1000) String kuvaus, List<Kysymys> kysymysList) {
		super();
		this.kyselyn_nimi = kyselyn_nimi;
		this.kuvaus = kuvaus;
		this.kysymysList = kysymysList;
	}

    
    
	public Kysely() {
		super();
		this.kyselyn_nimi = null;
		this.kuvaus = null;
		this.kysymysList = null;
	}



	public String getKuvaus() {
		return kuvaus;
	}



	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
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
		return "Kysely [kysely_id=" + kysely_id + ", kyselyn_nimi=" + kyselyn_nimi + ", kuvaus=" + kuvaus
				+ ", kysymysList=" + kysymysList + "]";
	}



	public List<Kysymys> getKysymysList(){
        return kysymysList;
    }
}
