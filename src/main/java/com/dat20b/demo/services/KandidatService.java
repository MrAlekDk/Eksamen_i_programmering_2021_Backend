
package com.dat20b.demo.services;

import com.dat20b.demo.models.Kandidat;
import com.dat20b.demo.models.Parti;
import com.dat20b.demo.repositories.KandidatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KandidatService {

    private KandidatRepository kandidatRepository;

    //Constructor injection
    public KandidatService(KandidatRepository kandidatRepository){
        this.kandidatRepository = kandidatRepository;
    }


    public List<Kandidat> getAllCandidates() {
        List<Kandidat> allCandidates = new ArrayList<>();
        kandidatRepository.findAll().forEach(candidate -> allCandidates.add(candidate));
        return allCandidates;
    }

    public void createNewCandidate(Kandidat newCandidate) {
        kandidatRepository.save(newCandidate);
    }

    public boolean updateCandidate(int candidateId, Kandidat updatedCandidate) {
        //update if candidate exist
        if(kandidatRepository.findById(candidateId).isPresent()){
            updatedCandidate.setKandidatId(candidateId);
            kandidatRepository.save(updatedCandidate);
            return true;
        }
        //create new candidate if not existing
        else{
            kandidatRepository.save(updatedCandidate);
            return false;
        }
    }

    public void deleteCandidate(int candidateId) {
        kandidatRepository.deleteById(candidateId);
    }

}
