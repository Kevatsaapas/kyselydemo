package com.kevatsaapas.kyselydemo.repository;

import com.kevatsaapas.kyselydemo.model.Kysely;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KyselyRepository extends CrudRepository <Kysely, Long>{
    Optional<Kysely> findById(Long id);

}
