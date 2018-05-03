package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysely;
import com.kevatsaapas.kyselydemo.model.Kyselyvastaus;
import com.kevatsaapas.kyselydemo.model.Kysymys;
import com.kevatsaapas.kyselydemo.model.Kysymysvastaus;
import com.kevatsaapas.kyselydemo.model.Vaihtoehto;

import ch.qos.logback.core.net.SyslogOutputStream;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ProcessBuilder.Redirect;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTController {

	 @Autowired
	    private KyselyRepository Krepository;
    @Autowired
    private KysymysRepository repository;
    @Autowired
    private VaihtoehtoRepository vrepository;
    @Autowired
    private KysymysvastausRepository kvrepo;
    
    

    @RequestMapping("kyselyt")
    public Iterable<Kysely> kyselyt(){ 
    	List<Kysely>kyselyt = (List<Kysely>) Krepository.findAll();
    	List<Kysymys> kysymykset = null;
    	List<Vaihtoehto> vaih = null;
    	for(int i=0; i<kyselyt.size(); i++){
    		Kysely kys = kyselyt.get(i);
    		kysymykset = repository.findByKyselyId(kys.getKyselyId());
    		for(int u=0; u<kysymykset.size(); u++){
        		Kysymys kysy = kysymykset.get(u);
        		String type = kysy.getTyyppi();
        		if(type=="text" || type=="textarea"){
        			System.out.println("teksti tais olla");
        		}else{
        		vaih = vrepository.findByKysymysId(kysy.getKysymysid());
        		kysy.setArvot(vaih);
        		kysymykset.set(u, kysy);
        		System.out.println(vaih.toString());
        		}
        	}
    		kys.setKysymysList(kysymykset);
    		kyselyt.set(i, kys);
    	}
    	
    	
    	return kyselyt;
    	
    }
    
    @RequestMapping("kyselynimet")
    public Iterable<Kysely> kyselyNimet(){ return Krepository.findAll();
    }

    @RequestMapping("kysymykset")
    public Iterable<Kysymys> kysymykset(){
    	List<Kysymys>kysymykset = (List<Kysymys>) repository.findAll();
    	List<Vaihtoehto> vaih = null;
    	for(int i=0; i<kysymykset.size(); i++){
    		Kysymys kys = kysymykset.get(i);
    		String type = kys.getTyyppi();
    		if(type=="text" || type=="textarea"){
    			System.out.println("teksti tais olla");
    		}else{
    		vaih = vrepository.findByKysymysId(kys.getKysymysid());
    		kys.setArvot(vaih);
    		kysymykset.set(i, kys);
    		System.out.println(vaih.toString());
    		}
    	}
    	return kysymykset;
    }

    @RequestMapping("kysymys/{id}")
    public Kysymys getKysymys(@PathVariable("id") Long id){
    	Optional<Kysymys> kys = repository.findById(id);
    	Kysymys kyss = kys.get();
    	String type = kyss.getTyyppi();
    	List<Vaihtoehto> vaih=null;
    	if(type!="text" || type!="textarea"){
    		vaih=vrepository.findByKysymysId(kyss.getKysymysid());
    		kyss.setArvot(vaih);
    	}
    	return kyss;
    }
    
    @RequestMapping("kysely/{id}")
    public Kysely getKysely(@PathVariable("id") Long id){
    	List<Vaihtoehto> vaih = null;
        Optional<Kysely> kysely =  Krepository.findById(id);
        Kysely kysely2 = (Kysely) kysely.get();
        List<Kysymys> kysymykset = repository.findByKyselyId(id);
        for(int i=0; i<kysymykset.size(); i++){
    		Kysymys kys = kysymykset.get(i);
    		String type = kys.getTyyppi();
    		if(type=="text" || type=="textarea"){
    			System.out.println("teksti tais olla");
    		}else{
    		vaih = vrepository.findByKysymysId(kys.getKysymysid());
    		kys.setArvot(vaih);
    		kysymykset.set(i, kys);
    		System.out.println(vaih.toString());
    		}
    	}
        kysely2.setKysymysList(kysymykset);
        return kysely2;
    }
    
    @RequestMapping("vastaukset/{id}")
    public List<Kysymysvastaus> haeVastaukset(@PathVariable("id")Long id){
    	List<Kysymysvastaus> kysvas = kvrepo.findByKysymysId(id);
    	return kysvas;
    }
    
    @RequestMapping("vastaukset/kysely/{id}")
    public Kysely haeKyselyVastaukset(@PathVariable("id")Long id){
    	Optional<Kysely> kysely = Krepository.findById(id);
    	Kysely kysely2 = kysely.get();
    	List<Kysymys> kysarit = repository.findByKyselyId(id);
    	List<Kysymysvastaus> vas = null;
    	for(int i=0; i<kysarit.size(); i++){
    		Kysymys kys = kysarit.get(i);
    		String type = kys.getTyyppi();
    		if(type!="text" || type!="textarea"){
    			List<Vaihtoehto> vaih = vrepository.findByKysymysId(kys.getKysymysid());
    			kys.setArvot(vaih);
    		}
    		vas = kvrepo.findByKysymysId(kys.getKysymysid());
    		kys.setKysymysvastaukset(vas);
    		kysarit.set(i, kys);
    	}
    	kysely2.setKysymysList(kysarit);
    	return kysely2;
    }
    
   /* @PostMapping("otavastaus")
    @ResponseBody
    public Kyselyvastaus otaVastaus(Kyselyvastaus kysvas, Kysymysvastaus kysyvas){
    	JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> result = springParser.parseMap(response.getBody());
    	
    	return kysvas;
    	
    }*/
    
    
 }
