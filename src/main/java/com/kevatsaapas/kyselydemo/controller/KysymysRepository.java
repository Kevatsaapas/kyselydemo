package com.kevatsaapas.kyselydemo.controller;

import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KysymysRepository extends CrudRepository <Kysymys, Long>{
    Optional<Kysymys> findById(Long id);

    /*@Query("select k from KYSYMYS k where k.kysely_id=:kysely_id")
    public List<Kysymys> findByKysely_id(@Param("kysely_id") Long kysely_id);*/
    List<Kysymys> findByKyselyId(Long kyselyId);
}
