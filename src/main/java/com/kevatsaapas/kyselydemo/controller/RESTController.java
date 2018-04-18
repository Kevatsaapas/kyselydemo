package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysely;
import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTController {

	 @Autowired
	    private KyselyRepository Krepository;
    @Autowired
    private KysymysRepository repository;
    

    @RequestMapping("kyselyt")
    public Iterable<Kysely> kyselyt(){ 
    	List<Kysely>kyselyt = (List<Kysely>) Krepository.findAll();
    	List<Kysymys> kysy = null;
    	for(int i=0; i<kyselyt.size(); i++){
    		Kysely kys = kyselyt.get(i);
    		kysy = repository.findByKyselyId(kys.getKyselyId());
    		kys.setKysymysList(kysy);
    		kyselyt.set(i, kys);
    	}
    	return kyselyt;
    	
    }
    
    @RequestMapping("kyselynimet")
    public Iterable<Kysely> kyselyNimet(){ return Krepository.findAll();
    }

    @RequestMapping("kysymykset")
    public Iterable<Kysymys> kysymykset(){ return repository.findAll();
    }

    @RequestMapping("kysely/{id}")
    public Kysely getKysely(@PathVariable("id") Long id){
        Optional<Kysely> kysely =  Krepository.findById(id);
        Kysely kysely2 = (Kysely) kysely.get();
        List<Kysymys> kysymykset = repository.findByKyselyId(id);
        kysely2.setKysymysList(kysymykset);
        return kysely2;
    }
}
