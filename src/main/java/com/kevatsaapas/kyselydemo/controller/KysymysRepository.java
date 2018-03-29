package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository <Kysymys, Long>{

}
