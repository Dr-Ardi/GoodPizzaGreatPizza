package com.example.gpgpBack.added;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AddedRepositoryTest {

    @Autowired
    private AddedRepository testAddedRep;

    @AfterEach
    void tearDown(){
        testAddedRep.deleteAll();
    }

    @Test
    void testGetAdditionsByType() {

    }

    @Test
    void testGetAllTypes() {

    }
}
