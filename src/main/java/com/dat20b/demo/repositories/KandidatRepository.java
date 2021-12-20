package com.dat20b.demo.repositories;

import com.dat20b.demo.models.Kandidat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KandidatRepository extends CrudRepository<Kandidat,Integer> {

    Iterable<Kandidat> findAllByParti(String partyName);
}
