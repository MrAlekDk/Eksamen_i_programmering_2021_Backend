//Author Alexander Sørensen, Dat20B 2021 - Programmerings eksamen
package com.dat20b.demo.controllers;

import com.dat20b.demo.models.Kandidat;
import com.dat20b.demo.services.KandidatService;
import com.dat20b.demo.services.PartiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="kandidater")
@CrossOrigin(origins = "*")
public class KandidatController {

    private KandidatService kandidatService;
    private PartiService partiService;

    //Constructor injection
    public KandidatController(KandidatService kandidatService,PartiService partiService){
        this.kandidatService = kandidatService;
        this.partiService = partiService;
    }

    @GetMapping
    public ResponseEntity<List<Kandidat>> getAllCandidates(){
        List<Kandidat> allCandidates = kandidatService.getAllCandidates();
        return new ResponseEntity<>(allCandidates, HttpStatus.OK);
    }
    //create new candidate, where pathvariable corresponds to partyId
    @PostMapping("/{partyId}")
    public ResponseEntity<Kandidat> createCandidate(@PathVariable int partyId, @RequestBody Kandidat newCandidate){
        //use partyId to get correct party and add it to the new candidate
        newCandidate.setParti(partiService.getSpecificParty(partyId));
        kandidatService.createNewCandidate(newCandidate);
        return new ResponseEntity<>(newCandidate, HttpStatus.CREATED);
    }

    //use candidateId to
    @PutMapping("/{candidateId}")
    public ResponseEntity<Kandidat> updateCandidate(@PathVariable int candidateId, @RequestBody Kandidat updatedCandidate){
        boolean candidateFound = kandidatService.updateCandidate(candidateId, updatedCandidate);
        if(candidateFound){
            return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(updatedCandidate, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity deleteCandidate(@PathVariable int candidateId){
        kandidatService.deleteCandidate(candidateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
