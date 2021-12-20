package com.dat20b.demo.services;

import com.dat20b.demo.models.Parti;
import com.dat20b.demo.repositories.PartiRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartiService {

    private PartiRepository partiRepository;

    //Constructor injection
    public PartiService(PartiRepository partiRepository){
        this.partiRepository = partiRepository;
    }

    //Find all parties in dB and return them as a list
    public List<Parti> getAllParties() {
        List<Parti> allParties = new ArrayList<>();
        partiRepository.findAll().forEach(parti -> allParties.add(parti));
        return allParties;
    }

    public Parti getSpecificParty(int partyId) {
        return partiRepository.findById(partyId).get();
    }

    public Parti getSpecificParty(String partyName) {
        return partiRepository.findByPartiNavn(partyName);
    }
}
