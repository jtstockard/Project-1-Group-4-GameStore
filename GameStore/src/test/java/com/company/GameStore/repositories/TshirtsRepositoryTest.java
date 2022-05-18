package com.company.GameStore.repositories;

import com.company.GameStore.models.Tshirts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtsRepositoryTest {

    @Autowired
    TshirtsRepository tshirtsRepository;

    @Before
    public void setUp() throws Exception {
        tshirtsRepository.deleteAll();
    }

    @Test
    public void addGetDeleteTshirts() {

        Tshirts tshirts = new Tshirts();
        tshirts.setSize("L");
        tshirts.setColor("Yellow");
        tshirts.setDescription("Ironic tshirt");
        tshirts.setPrice(new BigDecimal("9.99"));
        tshirts.setQuantity(308);

        tshirts = tshirtsRepository.save(tshirts);

        Optional<Tshirts> tshirts1 = tshirtsRepository.findById(tshirts.getId());

        assertEquals(tshirts1.get(), tshirts);

        tshirtsRepository.deleteById(tshirts.getId());

        tshirts1 = tshirtsRepository.findById(tshirts.getId());

        assertFalse(tshirts1.isPresent());
    }

    @Test
    public void updateTshirts() {
        Tshirts tshirts = new Tshirts();
        tshirts.setSize("L");
        tshirts.setColor("Yellow");
        tshirts.setDescription("Ironic tshirt");
        tshirts.setPrice(new BigDecimal("9.99"));
        tshirts.setQuantity(308);

        tshirts = tshirtsRepository.save(tshirts);

        tshirts.setSize("XL");
        tshirts.setColor("Black");
        tshirts.setDescription("Anime shirt");
        tshirts.setPrice(new BigDecimal("34.99"));
        tshirts.setQuantity(23);


        tshirtsRepository.save(tshirts);

        Optional<Tshirts> tshirts1 = tshirtsRepository.findById(tshirts.getId());
        assertEquals(tshirts1.get(), tshirts);
    }

    @Test
    public void getAllTshirts() {

        Tshirts tshirts = new Tshirts();
        tshirts.setSize("L");
        tshirts.setColor("Yellow");
        tshirts.setDescription("Ironic tshirt");
        tshirts.setPrice(new BigDecimal("9.99"));
        tshirts.setQuantity(308);

        tshirts = tshirtsRepository.save(tshirts);

        tshirts = new Tshirts();
        tshirts.setSize("XXL");
        tshirts.setColor("Orange");
        tshirts.setDescription("Killer robot tshirt");
        tshirts.setPrice(new BigDecimal("25.00"));
        tshirts.setQuantity(102);

        tshirts = tshirtsRepository.save(tshirts);

        List<Tshirts> tList = tshirtsRepository.findAll();
        assertEquals(tList.size(), 2);

    }

}