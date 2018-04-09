package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysymys;
import com.kevatsaapas.kyselydemo.controller.KysymysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private KysymysRepository repository;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/kysymykset")
    public Iterable<Kysymys> kysymykset(){ return repository.findAll();}

    @RequestMapping("/kysymykset/{id}")
    public Optional<Kysymys> getKysymys(@PathVariable("id") Long id){
        return repository.findById(id);
    }
}
