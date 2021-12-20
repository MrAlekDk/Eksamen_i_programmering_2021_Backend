//Author Alexander Sørensen, Dat20B 2021 - Programmerings eksamen
package com.dat20b.demo.controllers;

import com.dat20b.demo.models.Parti;
import com.dat20b.demo.services.PartiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping(value="/partier")
public class PartiController {

    private PartiService partiService;

    //Constructor injection
    public PartiController(PartiService partiService){
        this.partiService = partiService;
    }

    //retrieve all parties
    @GetMapping
    public ResponseEntity<List<Parti>> getAllParties(){
        List<Parti> allParties = partiService.getAllParties();
        return new ResponseEntity<>(allParties, HttpStatus.OK);
    }

    //retrieve specific party
    @GetMapping("/{partyName}")
    public ResponseEntity<Parti> getSpecificParty(@PathVariable String partyName){
        Parti specificParty = partiService.getSpecificParty(partyName);
        return new ResponseEntity<>(specificParty,HttpStatus.FOUND);
    }
}
