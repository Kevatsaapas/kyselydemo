package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KysymysRepository extends CrudRepository <Kysymys, Long>{
    List<Kysymys> findOne(Long id);
}
