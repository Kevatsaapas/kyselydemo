package com.kevatsaapas.kyselydemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kevatsaapas.kyselydemo.model.Kysymysvastaus;

@Repository
public interface KysymysvastausRepository extends CrudRepository <Kysymysvastaus, Long>{
    Optional<Kysymysvastaus> findById(Long id);
    List<Kysymysvastaus> findByKysymysId(Long kysymysId);
}