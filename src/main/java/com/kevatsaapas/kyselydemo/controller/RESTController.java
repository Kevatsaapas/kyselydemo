package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysely;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTController {

	 @Autowired
	    private KyselyRepository Krepository;
    

    @RequestMapping("kyselyt")
    public Iterable<Kysely> kyselyt(){ return Krepository.findAll();}

    @RequestMapping("kysely/{id}")
    public Optional<Kysely> getKysely(@PathVariable("id") Long id){
        return Krepository.findById(id);
    }
}
