package com.dat20b.demo.repositories;

import com.dat20b.demo.models.Parti;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiRepository extends CrudRepository<Parti,Integer> {

    Parti findByPartiNavn(String partyName);

}
