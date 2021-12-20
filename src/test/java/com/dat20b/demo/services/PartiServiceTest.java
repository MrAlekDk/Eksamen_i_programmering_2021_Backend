package com.dat20b.demo.services;

import com.dat20b.demo.models.Kandidat;
import com.dat20b.demo.models.Kommune;
import com.dat20b.demo.models.Parti;
import com.dat20b.demo.repositories.KandidatRepository;
import com.dat20b.demo.repositories.PartiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

class PartiServiceTest {

    List<Parti> testListOfParties = new ArrayList<>();

    @Mock
    PartiRepository partiRepository;

    @InjectMocks
    PartiService partiService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        //test region
        Kommune kommuneTest = new Kommune(8305,"Lejre");

        //test parties
        Parti partiTest1 = new Parti("Venstre",'V',kommuneTest);
        Parti partiTest2 = new Parti("Socialdemokratiet",'A',kommuneTest);
        Parti partiTest3 = new Parti("Alternativet",'Å',kommuneTest);

        testListOfParties.add(partiTest1);
        testListOfParties.add(partiTest2);
        testListOfParties.add(partiTest3);

        Mockito.when(partiRepository.findById(1)).thenReturn(java.util.Optional.of(partiTest1));
        Mockito.when(partiRepository.findByPartiNavn("Alternativet")).thenReturn(partiTest3);

        Mockito.when(partiRepository.save(partiTest1 )).thenReturn(partiTest1 );

        Mockito.when(partiRepository.findAll()).thenReturn(testListOfParties);
    }

    @Test
    void getAllPartiesTest(){
        List<Parti> testList = partiService.getAllParties();

        assertEquals(3,testList.size());
        Mockito.verify(partiRepository,times(1)).findAll();
    }

    @Test
    void getSpecificPartyByIntegerTest(){
        Parti testParti = partiService.getSpecificParty(1);

        assertEquals("Venstre",testParti.getPartiNavn());
        Mockito.verify(partiRepository,times(1)).findById(1);
    }

    @Test
    void getSpecificPartyByPartyNameTest(){
        Parti testParti = partiService.getSpecificParty("Alternativet");

        assertEquals("Alternativet",testParti.getPartiNavn());
        Mockito.verify(partiRepository,times(1)).findByPartiNavn("Alternativet");
    }

}