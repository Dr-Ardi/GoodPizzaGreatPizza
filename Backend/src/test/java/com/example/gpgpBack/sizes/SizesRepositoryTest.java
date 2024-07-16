package com.example.gpgpBack.sizes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class SizesRepositoryTest {

    @Autowired
    private SizesRepository testSizesRep;

    @AfterEach
    void tearDown(){
        testSizesRep.deleteAll();
    }

     @Test
    void testCheckSize() {
        // Given
        String itemType = "Burger";
        Sizes size = new Sizes("Burger", "Small", 5.0);
        testSizesRep.save(size);

        // When
        String result = testSizesRep.checkSize(itemType);

        // Then
        assertThat(result).isEqualTo(itemType);
    }

    @Test
    void testFindSizes() {
        // Given
        String itemType = "Burger";
        Sizes size1 = new Sizes( "Burger", "Small", 5.0);
        Sizes size2 = new Sizes("Burger", "Large", 8.0);
        testSizesRep.save(size1);
        testSizesRep.save(size2);

        // When
        List<Sizes> result = testSizesRep.findSizes(itemType);

        // Then
        assertThat(result).hasSize(2);
    }

}

