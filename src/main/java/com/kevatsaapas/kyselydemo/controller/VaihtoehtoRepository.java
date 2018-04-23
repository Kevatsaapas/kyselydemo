package com.kevatsaapas.kyselydemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kevatsaapas.kyselydemo.model.Vaihtoehto;

public interface VaihtoehtoRepository extends CrudRepository <Vaihtoehto, Long> {
	Optional<Vaihtoehto> findById(long id);
    List<Vaihtoehto> findByKysymysId(long kysymysId);
}
