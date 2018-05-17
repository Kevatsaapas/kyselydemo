package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.repository.KyselyRepository;
import com.kevatsaapas.kyselydemo.repository.KysymysRepository;
import com.kevatsaapas.kyselydemo.repository.KysymysvastausRepository;
import com.kevatsaapas.kyselydemo.model.Kysely;
import com.kevatsaapas.kyselydemo.model.Kyselyvastaus;
import com.kevatsaapas.kyselydemo.model.Kysymys;
import com.kevatsaapas.kyselydemo.model.Kysymysvastaus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

@Controller
public class DefaultController {

    @Autowired
    private KyselyRepository kyselyRepository;

    @Autowired
    private KysymysRepository kysymysRepository;
    
    @Autowired
    private KysymysvastausRepository kvrepo;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/uusikysely", method = RequestMethod.GET)
    public String uusiKysely(Model model){
        model.addAttribute("kysely", new Kysely());
        return "uusikysely";
    }

    @RequestMapping(value = "/kyselyt", method = RequestMethod.GET)
    public String Kyselyt(Model model){
        List<Kysely> kyselylist = (List<Kysely>)kyselyRepository.findAll();
        for(int i=0; i<kyselylist.size(); i++){
        	Kysely kys =kyselylist.get(i);
        	List<Kysymys> kyslist = kysymysRepository.findByKyselyId(kys.getKyselyId());
        	kys.setKysymysList(kyslist);
        	kyselylist.set(i, kys);
        }


        model.addAttribute("kyselyt", kyselylist);
        return "kyselylista";
    }

    @RequestMapping(value = "/uusikysely", method = RequestMethod.POST)
    public String tallennaKysely(Kysely kysely){

        kyselyRepository.save(kysely);

        return "redirect:/uusikysely";
    }

    @RequestMapping(value ="/uusikysymys/{kyselyId}", method = RequestMethod.GET)
    public String uusiKysymys(@PathVariable("kyselyId") Long kyselyId, Model model) {

        model.addAttribute("kysymys", new Kysymys());
        model.addAttribute("kyselyId", kyselyId);

        return "uusikysymys";
    }
    
    
    @RequestMapping(value="/otavastaus", method = RequestMethod.POST)
    public String otaVastaus(@RequestBody Kyselyvastaus kysvas){
   	List<Kysymysvastaus> vastaukset = kysvas.getVastaukset();
   	Kysymysvastaus kys = null;
   	for(int i=0; i<vastaukset.size(); i++){
   		kys = vastaukset.get(i);
   		kvrepo.save(kys);
   	}
   	System.out.println(kvrepo.findAll().toString());
		return "redirect:/";
   	 
    }

    @RequestMapping(value ="/uusikysymys/{kyselyId}", method = RequestMethod.POST)
    public String tallennaKysymys(@PathVariable("kyselyId") Long kyselyId, Kysymys kysymys) {

        kysymys.setKyselyId(kyselyId);
        kysymysRepository.save(kysymys);

        return "redirect:/uusikysymys/" + kyselyId;
    }

}
