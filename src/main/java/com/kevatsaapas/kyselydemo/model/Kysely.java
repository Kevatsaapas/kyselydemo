package com.kevatsaapas.kyselydemo.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import java.util.List;


@Entity
@Table(name = "kysely")
public class Kysely {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long kyselyId;

    private String kyselyNimi;

    @Column
    @Length(min=1, max=1000)
    private String kuvaus;
    
    @OneToMany
    private List<Kysymys> kysymysList;

    
    public Kysely(String kyselyNimi, @Length(min = 1, max = 1000) String kuvaus, List<Kysymys> kysymysList) {
		super();
		this.kyselyNimi = kyselyNimi;
		this.kuvaus = kuvaus;
		this.kysymysList = kysymysList;
	}

    
    
	public Kysely() {
		super();
		this.kyselyNimi = null;
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
        return kyselyId;
    }

    public void setKyselyId(Long kysely_id) {
        this.kyselyId = kysely_id;
    }

    public String getKyselyNimi() {
        return kyselyNimi;
    }

    public void setKyselyNimi(String kyselyn_nimi) {
        this.kyselyNimi = kyselyn_nimi;
    }

    public void setKysymysList(List<Kysymys> kysymysList) {
        this.kysymysList = kysymysList;
    }

   

    @Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", kyselyNimi=" + kyselyNimi + ", kuvaus=" + kuvaus
				+ ", kysymysList=" + kysymysList + "]";
	}



	public List<Kysymys> getKysymysList(){
        return kysymysList;
    }
}
