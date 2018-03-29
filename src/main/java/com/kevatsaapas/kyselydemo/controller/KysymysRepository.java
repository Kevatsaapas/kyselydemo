package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface KysymysRepository extends CrudRepository <Kysymys, Long>{
    Optional<Kysymys> findById(Long id);
}
