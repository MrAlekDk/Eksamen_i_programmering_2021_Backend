package com.dat20b.demo.services;

import com.dat20b.demo.models.Kandidat;
import com.dat20b.demo.models.Kommune;
import com.dat20b.demo.models.Parti;
import com.dat20b.demo.repositories.KandidatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class KandidatServiceTest {

    private List<Kandidat> testListOfCandidates = new ArrayList<>();

    @Mock
    KandidatRepository kandidatRepository;

    @InjectMocks
    KandidatService kandidatService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        //test region
        Kommune kommuneTest = new Kommune(8305,"Lejre");

        //test parties
        Parti partiTest1 = new Parti("Venstre",'V',kommuneTest);
        Parti partiTest2 = new Parti("Socialdemokratiet",'A',kommuneTest);
        Parti partiTest3 = new Parti("Alternativet",'Å',kommuneTest);


        //test candidates
        Kandidat kandidatTest1 = new Kandidat("Alexander",10,partiTest1);
        Kandidat kandidatTest2 = new Kandidat("Henriette",5,partiTest1);
        Kandidat kandidatTest3 = new Kandidat("Jens",0,partiTest2);
        Kandidat kandidatTest4 = new Kandidat("Anna",4,partiTest3);

        testListOfCandidates.add(kandidatTest1);
        testListOfCandidates.add(kandidatTest2);
        testListOfCandidates.add(kandidatTest3);
        testListOfCandidates.add(kandidatTest4);


        Mockito.when(kandidatRepository.findById(1)).thenReturn(java.util.Optional.of(kandidatTest1));

        Mockito.when(kandidatRepository.save(kandidatTest1)).thenReturn(kandidatTest1);

        Mockito.when(kandidatRepository.findAll()).thenReturn(testListOfCandidates);


    }

    @Test
    void getAllCandidatesTest(){
        List<Kandidat> testList = kandidatService.getAllCandidates();

        assertEquals(4,testList.size());
        Mockito.verify(kandidatRepository,times(1)).findAll();

    }

    @Test
    void createNewCandidateTest(){
        Kandidat kandidatTest = new Kandidat("Anna",4,
                new Parti("Partinavn",'P',
                        new Kommune(2020,"kommunenavn")));

        kandidatTest.setKandidatId(1);

        kandidatService.createNewCandidate(kandidatTest);

        Mockito.verify(kandidatRepository,times(1)).save(Mockito.any(Kandidat.class));
    }

    @Test
    void updateCandidateTest(){

        Kandidat candidateToUpdate = kandidatRepository.findById(1).get();

        candidateToUpdate.setNavn("Anna");

        kandidatService.updateCandidate(1,candidateToUpdate);

        assertEquals("Anna",kandidatRepository.findById(1).get().getNavn());
        Mockito.verify(kandidatRepository,times(1)).save(candidateToUpdate);
    }

    @Test
    void deleteCandidateTest(){
        int idToDelete = 1;

        kandidatService.deleteCandidate(idToDelete);

        //assertEquals(null,kandidatRepository.findById(1).get());
        Mockito.verify(kandidatRepository).deleteById(1);
    }

}