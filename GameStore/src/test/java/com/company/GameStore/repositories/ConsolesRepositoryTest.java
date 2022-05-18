package com.company.GameStore.repositories;

import com.company.GameStore.models.Consoles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsolesRepositoryTest {

    @Autowired
    ConsolesRepository consolesRepository;

    @Before
    public void setUp() throws Exception {
        consolesRepository.deleteAll();
    }

    @Test
    public void addGetDeleteConsoles() {

        Consoles consoles = new Consoles();
        consoles.setModel("Gamecube");
        consoles.setManufacturer("Nintendo");
        consoles.setMemoryAmount("128gb");
        consoles.setPrice(new BigDecimal("199.02"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(99);

        consoles = consolesRepository.save(consoles);

        Optional<Consoles> consoles1 = consolesRepository.findById(consoles.getId());

        assertEquals(consoles1.get(), consoles);

        consolesRepository.deleteById(consoles.getId());

        consoles1 = consolesRepository.findById(consoles.getId());

        assertFalse(consoles1.isPresent());
    }

    @Test
    public void updateConsoles() {
        Consoles consoles = new Consoles();
        consoles.setModel("Gamecube");
        consoles.setManufacturer("Nintendo");
        consoles.setMemoryAmount("128gb");
        consoles.setPrice(new BigDecimal("199.02"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(99);

        consoles = consolesRepository.save(consoles);

        consoles.setModel("PlayStation 3");
        consoles.setManufacturer("Sony");
        consoles.setMemoryAmount("256gb");
        consoles.setPrice(new BigDecimal("599.99"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(75);

        consolesRepository.save(consoles);

        Optional<Consoles> consoles1 = consolesRepository.findById(consoles.getId());
        assertEquals(consoles1.get(), consoles);
    }

    @Test
    public void getAllConsoles() {

        Consoles consoles = new Consoles();
        consoles.setModel("Gamecube");
        consoles.setManufacturer("Nintendo");
        consoles.setMemoryAmount("128gb");
        consoles.setPrice(new BigDecimal("199.02"));
        consoles.setProcessor("Intel");
        consoles.setQuantity(99);

        consoles = consolesRepository.save(consoles);

        consoles = new Consoles();
        consoles.setModel("Xbox");
        consoles.setManufacturer("Microsoft");
        consoles.setMemoryAmount("512gb");
        consoles.setPrice(new BigDecimal("725.01"));
        consoles.setProcessor("AMD");
        consoles.setQuantity(10);

        consoles = consolesRepository.save(consoles);

        List<Consoles> cList = consolesRepository.findAll();
        assertEquals(cList.size(), 2);

    }

}